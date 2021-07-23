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

    @GetMapping("/pelamar/dashboard")
    public String getDashboard(Model model, HttpServletRequest request) {
        model.addAttribute("pelamar", new Pelamar());

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
