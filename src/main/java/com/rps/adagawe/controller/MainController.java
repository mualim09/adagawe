package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.service.LowonganService;
import com.rps.adagawe.service.PelamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MainController {
    @Autowired
    private LowonganService lowonganService;

    @Autowired
    private PelamarService pelamarService;

    @Autowired
    private AdagaweService adagaweService;

//    private void redirectIndex(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userEmail = authentication.getName();
//
//        model.addAttribute("userEmail", userEmail);
//    }

    @GetMapping("/")
    public String indexPelamar(Model model) {

        List<Lowongan> lokers = lowonganService.getAll();
        model.addAttribute("lokers", lokers);


        return "main/index";
    }

    @GetMapping("/lowongan/{id}")
    public String lowongan(@PathVariable("id") int id, Model model) {
        Lowongan lowongan = lowonganService.getLowonganById(id);
        model.addAttribute("loker", lowongan);

        return "main/lowongan-detail";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "/main/about";
    }

    @GetMapping("/lowongan")
    public String lowonganKerja(Model model) {
        model.addAttribute("lokers", lowonganService.getAll());

        return "/main/lowongan";
    }

}
