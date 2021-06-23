package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @GetMapping("/pelamar/profile")
    public String viewPelamar(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserLogin ul = pelamarService.findUserLoginByEmail(authentication.getName());
//        int idPelamar = pelamarService.findPelamarByUserLogin(ul.getId()).getId();
//        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(1));
//        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(1));
//        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(1));

        int idPelamar = AdagaweMethods.getIdPelamarBySession(pelamarService);
        model.addAttribute("sertifikats", sertifikatService.getSertifikatByIdUser(idPelamar));
        model.addAttribute("pengalamans", pengalamanService.getPengalamanByIdUser(idPelamar));
        model.addAttribute("pendidikans", pendidikanService.getPendidikanByIdUser(idPelamar));
        return "pelamar/profile";
    }
}
