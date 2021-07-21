package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.JenisPegawai;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

        Pelamar pelamar = AdagaweMethods.getPelamarBySession(adagaweService);

        if (pelamar == null) {
            return "redirect:/pelamar/information";
        }

        model.addAttribute("pelamar", pelamar);
        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(pelamar.getId()));
        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(pelamar.getId()));
        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(pelamar.getId()));
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));

        return "/pelamar/profile/index";
    }

    @GetMapping("/pelamar/information")
    public String getInformation(Model model, HttpServletRequest request) {
        model.addAttribute("pelamar", new Pelamar());

        return "/pelamar/information";
    }

    @PostMapping("/pelamar/information")
    public String postInformation(@ModelAttribute("pelamar") @Valid Pelamar pelamar, BindingResult result,
                                  @RequestParam("file") MultipartFile file, Model model) {

        if (result.hasErrors()) {
            return "/pelamar/information";
        }

        if (file.isEmpty()){
            pelamar.setDokumenCv("not");
        }
        else {
            String fileName = FileUploadHelper.upload(file, "cv_pelamar");
            pelamar.setDokumenCv(fileName);
        }

        pelamar.setIdUserLogin(AdagaweMethods.getUserLoginBySession(adagaweService).getId());
        pelamarService.save(pelamar);

        return "redirect:/pelamar/profile";
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
