package com.rps.adagawe.controller;

import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.service.*;
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
public class PerusahaanController {

    @Autowired
    PerusahaanService perusahaanService;

    @GetMapping("/perusahaan")
    public String index(Model model) {
        List<Perusahaan> perusahaans = perusahaanService.findPerusahaanByRowStatus();
        model.addAttribute("perusahaans", perusahaans);
        return "/perusahaan/index";
    }

    @GetMapping("/perusahaan/create")
    public String create(Model model) {
        model.addAttribute("perusahaan", new Perusahaan());
        return "/perusahaan/create";
    }

    @PostMapping("/perusahaan/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {
        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return "/perusahaan/create";
        }

//        String fileName = FileUploadHelper.Upload(file);
//        perusahaan.setFotoProfil(fileName);
        perusahaanService.save(perusahaan);

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil ditambah.");
        return "redirect:/perusahaan";
    }

    @GetMapping("/perusahaan/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Perusahaan perusahaan = perusahaanService.getPerusahaanById(id);

        model.addAttribute("perusahaan", perusahaan);
        return "/perusahaan/edit";
    }

    @PostMapping("/perusahaan/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            perusahaan.setId(id);
            return "/perusahaan/edit";
        }

        Perusahaan p = perusahaanService.updatePerusahaan(id, perusahaan);
        if (p == null) {
            return "/perusahaan/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil diubah.");
        return "redirect:/perusahaan";
    }

    @PostMapping("/perusahaan/delete/{id}")
    public String deletePengalaman(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                   @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {
        Perusahaan emp = perusahaanService.deletePerusahaan(id, perusahaan);

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil dihapus.");
        return "redirect:/perusahaan";
    }
}
