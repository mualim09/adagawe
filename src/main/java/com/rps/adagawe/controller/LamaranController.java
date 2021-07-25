package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.*;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class LamaranController {
    @Autowired
    private LowonganService lowonganService;

    @Autowired
    private LamaranService lamaranService;

    @Autowired
    private PelamarService pelamarService;

    @Autowired
    private PengalamanService pengalamanService;

    @Autowired
    private SertifikatService sertifikatService;

    @Autowired
    private PendidikanService pendidikanService;

    @Autowired
    private NotifikasiService notifikasiService;

    @Autowired
    private AdagaweService adagaweService;

    @GetMapping("/lamaran/{id}")
    public String lamaran(@PathVariable("id") int id, Model model) {
        Lowongan lowongan = lowonganService.getLowonganById(id);
        model.addAttribute("loker", lowongan);
        model.addAttribute("lamaran", new Lamaran());

        return "/main/lamaran";
    }

    @PostMapping("/lamaran/{id}")
    public String saveLamaran(@PathVariable("id") int id, RedirectAttributes redirectAttributes, @RequestParam("resumeFile") MultipartFile file,
                              @ModelAttribute("lamaran") @Valid Lamaran lamaran, BindingResult result, Model model) {

        if (file.isEmpty()) {
            result.addError(new FieldError("resume", "resume", "Resume wajib diisi."));
        }

        Lowongan lowongan = lowonganService.getLowonganById(id);

        if (result.hasErrors()) {
            model.addAttribute("loker", lowongan);
            model.addAttribute("lamaran", lamaran);
            return "/main/lamaran";
        }

        String fileName = FileUploadHelper.upload(file, "resume");
        int idPelamar = AdagaweMethods.getPelamarBySession(adagaweService).getId();

        lamaran.setResume(fileName);
        lamaran.setTanggalMelamar(new Date());
        lamaran.setIdLowongan(lowongan.getId());
        lamaran.setIdPelamar(idPelamar);
        lamaran.setStatusLamaran(0);
        lamaranService.save(lamaran);

        return "redirect:/lamaran/result";
    }

    @GetMapping("/lamaran/result")
    public String lamaranResult() {
        return "main/lamaran-success";
    }

    @PostMapping("/perusahaan/lamaran/{id}/clean")
    public String seleksiLamaran(@PathVariable("id") int idLowongan) {
        lamaranService.eliminatePelamarByPendidikan(idLowongan);
        List<LamaranPelamar> lamaranPelamarList = pelamarService.getLamaranPelamarByIdLowongan(idLowongan);
        for(LamaranPelamar lamaranPelamar : lamaranPelamarList) {
            double tingkatanJenjang = Double.parseDouble(lamaranPelamar.getTingkatanJenjang());
            double jenjangMinimal = Double.parseDouble(lamaranPelamar.getJenjangMinimal().toString());

            Notifikasi notifikasi = new Notifikasi();
            notifikasi.setIdLamaran(lamaranPelamar.getIdLamaran());
            notifikasi.setTahap("Kualifikasi");
            notifikasi.setHasil(tingkatanJenjang < jenjangMinimal ? 0 : 1);
            notifikasi.setTahapSelanjutnya("Uji Kompetensi");
            notifikasi.setCreatedDate(new Date());
            notifikasiService.save(notifikasi);
        }

        return "redirect:/perusahaan/lowongan/detail/" + idLowongan;
    }

    @GetMapping("/perusahaan/lamaran/view/{id}")
    public String viewLamaran(@PathVariable("id") int idLamaran, Model model) {
        LamaranPelamar lamaranPelamar = pelamarService.getPelamarByIdLamaran(idLamaran);

        model.addAttribute("pelamar", lamaranPelamar);
        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(lamaranPelamar.getIdPelamar()));
        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(lamaranPelamar.getIdPelamar()));
        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(lamaranPelamar.getIdPelamar()));
        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));

        return "perusahaan/lamaran/detail";
    }

    @PostMapping("/perusahaan/lamaran/nilaiujikompetensi/{id}")
    public String saveNilaiUjiKompetensi(@PathVariable("id") int idLamaran,
                                         @RequestParam("nilai") Double nilai) {
        Lamaran lamaran = lamaranService.getLamaranById(idLamaran);
        lamaran.setNilaiUjiKompetensi(nilai);

        lamaranService.save(lamaran);

        return "redirect:/perusahaan/lowongan/detail/" + lamaran.getIdLowongan();
    }

    @PostMapping("/perusahaan/lamaran/nilaiwawancara/{id}")
    public String saveNilaiWawancara(@PathVariable("id") int idLamaran,
                                         @RequestParam("nilai") Double nilai) {
        Lamaran lamaran = lamaranService.getLamaranById(idLamaran);
        lamaran.setNilaiWawancara(nilai);

        lamaranService.save(lamaran);

        return "redirect:/perusahaan/lowongan/detail/" + lamaran.getIdLowongan();
    }

    @PostMapping("/perusahaan/lamaran/terima/{id}")
    public String terimaTahapan(@PathVariable("id") int idLamaran, @RequestParam("tahap") String tahap,
                                      @RequestParam("tahap_selanjutnya") String tahapSelanjutnya,
                                      @RequestParam(value = "tanggal_tahap", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date tanggalTahap,
                                @RequestParam("status") int status) {
        Lamaran lamaran = lamaranService.getLamaranById(idLamaran);
        lamaran.setStatusLamaran(status);
        lamaranService.save(lamaran);

        Notifikasi notifikasi = new Notifikasi();
        notifikasi.setIdLamaran(idLamaran);
        notifikasi.setTahap(tahap);
        notifikasi.setHasil(1);
        notifikasi.setTahapSelanjutnya(tahapSelanjutnya);
        notifikasi.setTanggalTahapan(tanggalTahap);
        notifikasi.setCreatedDate(new Date());

        notifikasiService.save(notifikasi);

        return "redirect:/perusahaan/lowongan/detail/" + lamaran.getIdLowongan();
    }

    @PostMapping("/perusahaan/lamaran/tolak/{id}")
    public String tolakTahapan(@PathVariable("id") int idLamaran, @RequestParam("tahap") String tahap,
                                @RequestParam("tahap_selanjutnya") String tahapSelanjutnya,
                                @RequestParam(value = "tanggal_tahap", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date tanggalTahap,
                                @RequestParam("status") int status) {
        Lamaran lamaran = lamaranService.getLamaranById(idLamaran);
        lamaran.setStatusLamaran(status);
        lamaranService.save(lamaran);

        Notifikasi notifikasi = new Notifikasi();
        notifikasi.setIdLamaran(idLamaran);
        notifikasi.setTahap(tahap);
        notifikasi.setHasil(0);
        notifikasi.setTahapSelanjutnya(tahapSelanjutnya);
        notifikasi.setTanggalTahapan(tanggalTahap);
        notifikasi.setCreatedDate(new Date());

        notifikasiService.save(notifikasi);

        return "redirect:/perusahaan/lowongan/detail/" + lamaran.getIdLowongan();
    }

    @PostMapping("/perusahaan/lamaran/schedule-wawancara/{id}")
    public String scheduleNotifikasi(@PathVariable("id") int idLamaran, @RequestParam("tahap") String tahap,
                                     @RequestParam(value = "tanggal_tahap", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") Date tanggalTahap) {
        Lamaran lamaran = lamaranService.getLamaranById(idLamaran);

        Notifikasi notifikasi = notifikasiService.get

        return "redirect:/perusahaan/lowongan/detail/" + lamaran.getIdLowongan();
    }
}
