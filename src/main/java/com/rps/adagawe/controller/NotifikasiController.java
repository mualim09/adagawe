package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.service.NotifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotifikasiController {

    @Autowired
    NotifikasiService notifikasiService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/pelamar/notifikasi")
    public String getIndex(Model model, HttpServletRequest request) {
        model.addAttribute("pelamar", AdagaweMethods.getPelamarBySession(adagaweService));
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        model.addAttribute("notifications", notifikasiService.getAll());

        return "/pelamar/notifikasi/index";
    }
}
