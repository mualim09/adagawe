package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.*;
import com.rps.adagawe.service.*;
import org.dom4j.rule.Mode;
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

    @Autowired
    VerifikasiPerusahaanService verifikasiPerusahaanService;

    @GetMapping("/admin/perusahaan")
    public String index(Model model) {
        List<Perusahaan> perusahaans = perusahaanService.findPerusahaanByRowStatus();
        model.addAttribute("perusahaans", perusahaans);
        return "/admin/perusahaan/index";
    }

    @GetMapping("/perusahaan/verifikasi/create")
    public String create(Model model) {
        model.addAttribute("perusahaan", new Perusahaan());
        return "/perusahaan/verifikasi/create";
    }

    @PostMapping("/perusahaan/verifikasi/create")
    public String postCreate(RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file,
                             @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/perusahaan/verifikasi/create";
        }

        UserLogin ul = AdagaweMethods.getUserLoginBySession(adagaweService);

        perusahaan.setIdUserLogin(ul.getId());

        if (file.isEmpty()){
            perusahaan.setFotoProfil("default.jpg");
        } else {
            String fileName = FileUploadHelper.upload(file, "foto_profil");
            perusahaan.setFotoProfil(fileName);
        }
        perusahaanService.save(perusahaan);

        //redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil ditambah.");
        return "redirect:/perusahaan/verifikasi/createnext";
    }

/*    @GetMapping("/perusahaan/edit/{id}")
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
    }*/


//    Perusahaan User
    @GetMapping("/perusahaan")
    public String userPerusahaanIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        model.addAttribute("userEmail", userEmail);
        //return "/main/index-perusahaan";
        return "/perusahaan/dashboard";
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

    @GetMapping("/perusahaan/profile")
    public String profile(Model model) {

        UserLogin idUserLogin = AdagaweMethods.getUserLoginBySession(adagaweService);
        List<Integer> perusahaan = perusahaanService.getIdUserLoginInPerusahaan();
        String prefix;

        if (perusahaan.contains(idUserLogin.getId()))
        {
            int idPerusahaan = AdagaweMethods.getIdPerusahaanBySession(adagaweService);
            VerifikasiPerusahaan verifikasiperusahaan = verifikasiPerusahaanService.getLastIdPerusahaan(idPerusahaan);
                    //getVerifikasiPerusahaanById(idPerusahaan);

            model.addAttribute("verifikasiperusahaan", verifikasiperusahaan);
            prefix = "/perusahaan/profile/index";
        }else{
            prefix = "/perusahaan/profile/create";
        }
        return prefix;
    }
}
