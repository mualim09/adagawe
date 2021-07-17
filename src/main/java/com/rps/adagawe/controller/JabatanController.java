package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class JabatanController {

    @Autowired
    JabatanService jabatanService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/admin/jabatan")
    public String getIndex(Model model, HttpServletRequest request) {
        List<Jabatan> jabatans = jabatanService.findJabatanByRowStatus();
        model.addAttribute("jabatans", jabatans);

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jabatan/index";
    }

    @GetMapping("/admin/jabatan/create")
    public String getCreate(Model model, HttpServletRequest request) {
        model.addAttribute("jabatan", new Jabatan());

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jabatan/create";
    }

    @PostMapping("/admin/jabatan/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/admin/jabatan/create";
        }

        jabatanService.save(jabatan);

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil ditambah.");
        return "redirect:/admin/jabatan";
    }


    @GetMapping("/admin/jabatan/edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        model.addAttribute("jabatan", jabatanService.getJabatanById(id));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jabatan/edit";
    }

    @PostMapping("/admin/jabatan/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            jabatan.setId(id);
            return "/admin/jabatan/edit";
        }

        Jabatan p = jabatanService.updateJabatan(id, jabatan);
        if (p == null) {
            return "/admin/jabatan/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil diubah.");
        return "redirect:/admin/jabatan";
    }

    @PostMapping("/admin/jabatan/delete/{id}")
    public String deleteJabatan(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                @ModelAttribute("jabatan") @Valid Jabatan jabatan, BindingResult result, Model model) {

        Jabatan p = jabatanService.deleteJabatan(id, jabatan);

        redirectAttributes.addFlashAttribute("message", "Jabatan berhasil dihapus.");
        return "redirect:/admin/jabatan";
    }
}
