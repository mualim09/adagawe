package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/admin/perusahaan")
    public String index(Model model) {
        List<Perusahaan> perusahaans = perusahaanService.findPerusahaanByRowStatus();
        model.addAttribute("perusahaans", perusahaans);
        return "/admin/perusahaan/index";
    }

    @GetMapping("/admin/perusahaan/create")
    public String create(Model model) {
        model.addAttribute("perusahaan", new Perusahaan());
        return "/admin/perusahaan/create";
    }

    @PostMapping("/admin/perusahaan/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {
        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return "/admin/perusahaan/create";
        }

//        String fileName = FileUploadHelper.Upload(file);
//        perusahaan.setFotoProfil(fileName);
        perusahaanService.save(perusahaan);

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil ditambah.");
        return "redirect:/admin/perusahaan";
    }

    @GetMapping("/admin/perusahaan/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Perusahaan perusahaan = perusahaanService.getPerusahaanById(id);

        model.addAttribute("perusahaan", perusahaan);
        return "/admin/perusahaan/edit";
    }

    @PostMapping("/admin/perusahaan/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            perusahaan.setId(id);
            return "/admin/perusahaan/edit";
        }

        Perusahaan p = perusahaanService.updatePerusahaan(id, perusahaan);
        if (p == null) {
            return "/admin/perusahaan/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil diubah.");
        return "redirect:/admin/perusahaan";
    }

    @PostMapping("/admin/perusahaan/delete/{id}")
    public String deletePengalaman(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                   @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {
        Perusahaan emp = perusahaanService.deletePerusahaan(id, perusahaan);

        redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil dihapus.");
        return "redirect:/admin/perusahaan";
    }


//    Perusahaan User
    @GetMapping("/perusahaan")
    public String userPerusahaanIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        model.addAttribute("userEmail", userEmail);
        return "/main/index-perusahaan";
    }


    @GetMapping("/perusahaan/view")
    public String getViewPerusahaan(Model model) {
        int idPerusahaan = AdagaweMethods.getIdPerusahaanBySession(adagaweService);
        Perusahaan perusahaan = perusahaanService.getPerusahaanById(idPerusahaan);

        return "/perusahaan/index";
    }

    @GetMapping("/perusahaan/profile/edit")
    public String getEditPerusahaan(Model model) {
        int idPerusahaan = AdagaweMethods.getIdPerusahaanBySession(adagaweService);
        Perusahaan perusahaan = perusahaanService.getPerusahaanById(idPerusahaan);

        model.addAttribute("perusahaan", perusahaan);
        return "/perusahaan/profile/edit";
    }

    @GetMapping("/perusahaan/profile/security")
    public String getSecurityPerusahaan(Model model) {
        UserLogin userLogin = adagaweService.findUserLoginByEmail(AdagaweMethods.getEmailUserBySession());
        model.addAttribute("userLogin", userLogin);

        return "/perusahaan/profile/security";
    }
}
