package com.rps.adagawe.controller;

import com.rps.adagawe.repository.LowonganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {
    @Autowired
    private LowonganRepository lowonganRepository;

    private void redirectIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        model.addAttribute("userEmail", userEmail);
    }

    @GetMapping("/")
    public String indexPelamar(Model model) {
        model.addAttribute("lokers", lowonganRepository.findAll());

        return "main/index";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        redirectIndex(model);
        return "main/index-admin";
    }

    @GetMapping("/lowongan/{id}")
    public String lowongan(@PathVariable("id") int id, Model model) {
        model.addAttribute("loker", lowonganRepository.findById(id));

        return "main/detail";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "/main/about";
    }

    @GetMapping("/lowongan")
    public String lowonganKerja(Model model) {
        model.addAttribute("lokers", lowonganRepository.findAll());

        return "/main/lowongan";
    }
}
