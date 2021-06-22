package com.rps.adagawe.controller;

import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.SertifikatService;
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
public class SertifikatController {

    @Autowired
    SertifikatService sertifikatService;

    @Autowired
    PelamarService pelamarService;

    @GetMapping("/sertifikat")
    public String index(Model model) {
        List<Sertifikat> sertifikats = sertifikatService.getAll();
        model.addAttribute("sertifikats", sertifikats);
        return "/sertifikat/index";
    }

    @GetMapping("/sertifikat/create")
    public String create(Model model) {
//        model.addAttribute("jabatans", jabatanService.getAll());
//        model.addAttribute("jenisPegawais", jenisPegawaiService.getAll());
        model.addAttribute("sertifikat", new Sertifikat());
        return "/sertifikat/create";
    }

    @PostMapping("/sertifikat/create")
    public String postCreate(RedirectAttributes redirectAttributes, @ModelAttribute("sertifikat") @Valid Sertifikat sertifikat,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/sertifikat/create";
        }

        Pelamar pelamar = pelamarService.getPelamarById(1);
        sertifikat.setPelamar(pelamar);
        sertifikat.setStatus(0);
        sertifikatService.save(sertifikat);

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil ditambah.");
        return "redirect:/sertifikat";
    }


    @GetMapping("/sertifikat/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Sertifikat sertifikat = sertifikatService.getSertifikatById(id);
        model.addAttribute("sertifikat", sertifikat);
        return "/sertifikat/edit";
    }

    @PostMapping("/sertifikat/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("sertifikat") @Valid Sertifikat sertifikat, BindingResult result, Model model) {

        if (result.hasErrors()) {
            sertifikat.setId(id);
            return "/sertifikat/edit";
        }

        Sertifikat p = sertifikatService.updateSertifikat(id, sertifikat);
        if (p == null) {
            return "/sertifikat/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil diubah.");
        return "redirect:/sertifikat";
    }

    @PostMapping("/sertifikat/delete/{id}")
    public String deleteSertifikat(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
        Sertifikat data = sertifikatService.deleteSertifikat(id);

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil dihapus.");
        return "redirect:/sertifikat";
    }
}
