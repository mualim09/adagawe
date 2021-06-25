package com.rps.adagawe.controller;

import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.service.JabatanService;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.PengalamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PengalamanController {
    @Autowired
    PengalamanService pengalamanService;

    @Autowired
    PelamarService pelamarService;

    @Autowired
    JabatanService jabatanService;

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    // Prefix URL
    private final String PREFIX = "/pelamar/pengalaman";
    private final String PREFIX_CREATE = "/pelamar/pengalaman/create";
    private final String PREFIX_EDIT = "/pelamar/pengalaman/edit";

    @GetMapping(PREFIX_CREATE)
    public String create(Model model) {
        model.addAttribute("jabatans", jabatanService.findJabatanByRowStatus());
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("pengalaman", new Pengalaman());

        return PREFIX_CREATE;
    }

    /**
     * Menambah Data Pengalaman
     * @CheckedBy Rifqy
     */
    @PostMapping(PREFIX_CREATE)
    public String postCreate(RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file,
                             @ModelAttribute("pengalaman") @Valid Pengalaman pengalaman, BindingResult result, Model model) {
        if (pengalaman.getJabatan().getId() == null) {
            result.addError(new FieldError("pengalaman", "jabatan", "Jabatan wajib diisi."));
        }

        if (pengalaman.getJenisPegawai().getId() == null) {
            result.addError(new FieldError("pengalaman", "jenisPegawai", "Jenis pegawai wajib diisi."));
        }

        if (result.hasErrors()) {
            model.addAttribute("jabatans", jabatanService.findJabatanByRowStatus());
            model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
            return PREFIX_CREATE;
        }

        String fileName = FileUploadHelper.Upload(file);
        Pelamar pelamar = pelamarService.getPelamarById(1);
        pengalaman.setPelamar(pelamar);
        pengalaman.setFileAttachment(fileName);
        pengalamanService.save(pengalaman);

        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil ditambah.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }

    @GetMapping(PREFIX_EDIT + "/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Pengalaman pengalaman = pengalamanService.getPengalamanById(id);
        model.addAttribute("jabatans", jabatanService.findJabatanByRowStatus());
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("pengalaman", pengalaman);

        return PREFIX_EDIT;
    }

    /**
     * Mengubah Data Pengalaman
     * @CheckedBy Rifqy
     */
    @PostMapping(PREFIX_EDIT + "/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                               @ModelAttribute("pengalaman") @Valid Pengalaman pengalaman, BindingResult result, Model model) {
        if (pengalaman.getJabatan().getId() == null) {
            result.addError(new FieldError("pengalaman", "jabatan", "Jabatan wajib diisi."));
        }

        if (pengalaman.getJenisPegawai().getId() == null) {
            result.addError(new FieldError("pengalaman", "jenisPegawai", "Jenis pegawai wajib diisi."));
        }

        if (result.hasErrors()) {
            pengalaman.setId(id);
            model.addAttribute("jabatans", jabatanService.getAll());
            model.addAttribute("jenisPegawais", jenisPegawaiService.getAll());
            return PREFIX_EDIT;
        }

        Pengalaman p = pengalamanService.updatePengalaman(id, pengalaman);
        if (p == null) {
            return PREFIX_EDIT;
        }

        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil diubah.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }

    /**
     * Mengubah Status Pengalaman Menjadi 0 (Tidak Aktif)
     * @CheckedBy Rifqy
     */
    @PostMapping(PREFIX + "/delete/{id}")
    public String deletePengalaman(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                   @ModelAttribute("jenispegawai") @Valid Pengalaman pengalaman, BindingResult result, Model model) {
        Pengalaman emp = pengalamanService.deletePengalaman(id, pengalaman);

        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil dihapus.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }
}
