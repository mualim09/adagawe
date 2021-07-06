package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        int idPelamar = AdagaweMethods.getIdPelamarBySession(adagaweService);
        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(idPelamar));
        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(idPelamar));
        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(idPelamar));

        return "/pelamar/profile/index";
    }

    @GetMapping("/pelamar/profile/security")
    public String getSecurity(Model model) {

        //UserLogin userLogin = userService.getUserLoginByEmail(AdagaweMethods.getEmailUserBySession());
        //model.addAttribute("userLogin", userLogin);
        return PREFIX_SECURITY;
    }

    @PostMapping("/pelamar/profile/security")
    public String postSecurity(@ModelAttribute("userLogin") @Valid UserLogin userLogin, BindingResult result, Model model) {

        //userService.updateUserLogin(userLogin);
        return "/pelamar/profile/index";
    }

    @GetMapping("/pelamar/profile/edit")
    public String getProfileEdit(Model model) {

        //pelamar pelamar = pelamarService.getpelamarById(AdagaweMethods.getIdpelamarBySession(pelamarService));
        //pelamar pelamar = pelamarService.getpelamarById(1);
        //model.addAttribute("pelamar", pelamar);
        return "/pelamar/profile/edit";
    }
}
