package com.rps.adagawe.controller;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.SertifikatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/admin/view")
    public String create(Model model) {
        Admin admin = adminService.getAdminById(1);
        model.addAttribute("admin", admin);
        return "/admin/view";
    }
}
