package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.service.*;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.LaporanService;
import com.rps.adagawe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created on June, 2021
 * @author RPS
 * @status FINAL
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    LaporanService laporanService;

    @GetMapping("/admin/profile")
    public String getProfile(Model model, HttpServletRequest request) {
        model.addAttribute("admin", AdagaweMethods.getAdminBySession(adagaweService));
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/profile/index";
    }

    @GetMapping("/admin/laporan-bidang")
    public String getLaporanBidang(Model model, HttpServletRequest request) {
        model.addAttribute("admin", AdagaweMethods.getAdminBySession(adagaweService));
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("bidangs", laporanService.getBidang());
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/laporan/laporan-bidang";
    }

    @GetMapping("/admin/laporan-daerah")
    public String getLaporanDaerah(Model model, HttpServletRequest request) {
        model.addAttribute("admin", AdagaweMethods.getAdminBySession(adagaweService));
        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("daerahs", laporanService.getDaerah());
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/laporan/laporan-daerah";
    }
}
