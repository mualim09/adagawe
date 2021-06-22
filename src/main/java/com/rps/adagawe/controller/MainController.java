package com.rps.adagawe.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    private void redirectIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        model.addAttribute("userEmail", userEmail);
    }

    @GetMapping("/")
    public String pelamarIndex(Model model) {
        return "main/index";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        redirectIndex(model);
        return "main/index-admin";
    }

//    @GetMapping("/perusahaan")
//    public String indexPerusahaan(Model model) {
//        redirectIndex(model);
//        return "main/index-perusahaan";
//    }
}
