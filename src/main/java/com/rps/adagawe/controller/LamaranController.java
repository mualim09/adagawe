package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Lamaran;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.service.LamaranService;
import com.rps.adagawe.service.LowonganService;
import com.rps.adagawe.service.PelamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class LamaranController {
    @Autowired
    private LowonganService lowonganService;

    @Autowired
    private LamaranService lamaranService;

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
        int idPelamar = AdagaweMethods.getIdPelamarBySession(adagaweService);

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

        return "redirect:/perusahaan/lowongan/detail/" + idLowongan;
    }

    @GetMapping("/perusahaan/lamaran/view/{id}")
    public String viewLamaran(@PathVariable("id") int idLamaran) {
        return "";
    }
}
