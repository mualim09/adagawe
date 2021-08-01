package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.Notifikasi;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.service.NotifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotifikasiController {

    @Autowired
    NotifikasiService notifikasiService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/pelamar/notifikasi")
    public String getIndex(Model model, HttpServletRequest request) {
        Pelamar pelamar = AdagaweMethods.getPelamarBySession(adagaweService);

        model.addAttribute("pelamar", pelamar);
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        model.addAttribute("notifications", notifikasiService.getNotifikasiByPelamar(pelamar.getId()));

        return "/pelamar/notifikasi/index";
    }

    @GetMapping("/notifikasi/konfirmasi/{konfirmasi}/{id}")
    public String konfirmasi(Model model, @PathVariable("id") int id, @PathVariable("konfirmasi") int konfirmasi) {
        notifikasiService.konfirmasi(id, konfirmasi);

        return "redirect:/pelamar/notifikasi";
    }
}
