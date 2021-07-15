package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/admin/dashboard")
    public String getViewAdminDashboard(Model model) {
        model.addAttribute("total_pelamar", adagaweService.findTotalUserByRole(1));
        model.addAttribute("total_perusahaan", adagaweService.findTotalUserByRole(2));
        model.addAttribute("total_lowongan", adagaweService.findTotalLamaran());

        return "/admin/dashboard";
    }

    @GetMapping("/perusahaan/dashboard")
    public String getViewPerusahaanDashboard(Model model) {

        return "/perusahaan/dashboard";
    }


}
