package com.rps.adagawe.controller;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.service.JabatanService;
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
public class JabatanController {

    @Autowired
    JabatanService jabatanService;

    @GetMapping("/admin/jabatan")
    public String index(Model model) {
            List<Jabatan> jabatans = jabatanService.findJabatanByRowStatus();
        model.addAttribute("jabatans", jabatans);
        return "/jabatan/index";
    }

    @GetMapping("/admin/jabatan/create")
    public String create(Model model) {
        model.addAttribute("jabatan", new Jabatan());
        return "/jabatan/create";
    }

    @PostMapping("/admin/jabatan/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/jabatan/create";
        }

        jabatanService.save(jabatan);

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil ditambah.");
        return "redirect:/jabatan";
    }


    @GetMapping("/admin/jabatan/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Jabatan jabatan = jabatanService.getJabatanById(id);

        model.addAttribute("jabatan", jabatan);
        return "/jabatan/edit";
    }

    @PostMapping("/admin/jabatan/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            jabatan.setId(id);
            return "/jabatan/edit";
        }

        Jabatan p = jabatanService.updateJabatan(id, jabatan);
        if (p == null) {
            return "/jabatan/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil diubah.");
        return "redirect:/jabatan";
    }

    @PostMapping("/admin/jabatan/delete/{id}")
    public String deleteJabatan(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        Jabatan p = jabatanService.deleteJabatan(id, jabatan);

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil dihapus.");
        return "redirect:/jabatan";
    }
}
