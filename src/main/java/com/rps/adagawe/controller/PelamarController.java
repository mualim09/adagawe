package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class PelamarController {

    @Autowired
    PelamarService pelamarService;

    @Autowired
    PengalamanService pengalamanService;

    @Autowired
    PendidikanService pendidikanService;

    @Autowired
    SertifikatService sertifikatService;

    @Autowired
    AdagaweService adagaweService;


    // Prefix URL
    private final String PREFIX = "/pelamar/profile";
    private final String PREFIX_SECURITY = "/pelamar/profile/security";
    private final String PREFIX_EDIT = "/pelamar/profile/edit";

    @GetMapping("/pelamar/profile")
    public String getView(Model model) {

        // Redirect jika belum melengkapi profil
        if (!AdagaweMethods.isPelamarExist(adagaweService)) {
            return "redirect:/pelamar/information";
        }

        int idPelamar = AdagaweMethods.getPelamarBySession(adagaweService).getId();
        UserLogin userLogin = AdagaweMethods.getUserLoginBySession(adagaweService);

        model.addAttribute("pelamar", pelamarService.getPelamarById(idPelamar));
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(idPelamar));
        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(idPelamar));
        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(idPelamar));

        return "/pelamar/profile/index";
    }

    @GetMapping("/pelamar/information")
    public String getInformation(Model model, HttpServletRequest request) {
        model.addAttribute("pelamar", new Pelamar());

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/pelamar/information";
    }

    @PostMapping("/pelamar/information")
    public String postInformation(RedirectAttributes redirectAttributes, @ModelAttribute("pelamar") @Valid Pelamar pelamar, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/pelamar/information";
        }

        pelamar.setIdUserLogin(AdagaweMethods.getUserLoginBySession(adagaweService).getId());
        pelamarService.save(pelamar);

        redirectAttributes.addFlashAttribute("message_success", "Selamat datang, lengkapi profil kamu agar dilirik perusahaan!");

        return "redirect:/pelamar/setting";
    }

    @GetMapping("/pelamar/dashboard")
    public String getDashboard(Model model, HttpServletRequest request) {

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/pelamar/dashboard";
    }

    @GetMapping("/pelamar/setting")
    public String getSetting(Model model, HttpServletRequest request) {

        model.addAttribute("pelamar", AdagaweMethods.getPelamarBySession(adagaweService));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/pelamar/profile/setting";
    }
}
