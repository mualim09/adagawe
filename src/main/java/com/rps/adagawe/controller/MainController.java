package com.rps.adagawe.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    private void redirectIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        model.addAttribute("userEmail", userEmail);
    }

    @GetMapping("/")
    public String indexPelamar(Model model) {
        return "main/index";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        redirectIndex(model);
        return "main/index-admin";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "/main/about";
    }

    @GetMapping("/lowongan")
    public String lowonganKerja() {
        return "/main/lowongan";
    }
}
