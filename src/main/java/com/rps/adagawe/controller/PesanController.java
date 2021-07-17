package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.service.PercakapanService;
import com.rps.adagawe.service.PesanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PesanController {

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    PesanService pesanService;

    @Autowired
    PercakapanService percakapanService;

    @GetMapping("/pelamar/messages")
    public String getMessagesPelamar(Model model) {

        return "/pelamar/profile/index";
    }

    @GetMapping("/perusahaan/messages")
    public String getMessagesPerusahaan(Model model, HttpServletRequest request) {

        model.addAttribute("pesans", pesanService.getByPesanUntuk(11));
        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/pesan";
    }

    @GetMapping("/perusahaan/messages/{id}")
    public String getConversationPerusahaan(@PathVariable("id") int id, Model model, HttpServletRequest request) {

        model.addAttribute("user", AdagaweMethods.getUserLoginByEmail(adagaweService,"samodra.me@gmail.com"));
        model.addAttribute("percakapans", percakapanService.getPercakapanByPesan(id));;
        model.addAttribute("idUserLogin", AdagaweMethods.getUserLoginBySession(adagaweService).getId());;
        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/percakapan";
    }
}
