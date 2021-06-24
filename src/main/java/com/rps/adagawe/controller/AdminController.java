package com.rps.adagawe.controller;

import com.rps.adagawe.helper.UserAdmin;
import com.rps.adagawe.model.*;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.SertifikatService;
import com.rps.adagawe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @GetMapping("/admin/view")
    public String view(Model model) {
        Admin admin = adminService.getAdminById(1);
        model.addAttribute("admin", admin);
        return "/admin/view";
    }

    @GetMapping("/admin/create")
    public String getCreate(Model model) {

        model.addAttribute("userAdmin", new UserAdmin());
        return "/admin/create";
    }

    @PostMapping("/admin/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("userAdmin") @Valid UserAdmin userAdmin, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/admin/create";
        }

        UserLogin user = new UserLogin();
        user.setEmail(userAdmin.getEmail());
        user.setPassword(userAdmin.getPassword());
        user.setUserRole(UserRole.Admin);
        userService.signUpUser(user);

        Admin admin = new Admin();
        admin.setNamaAdmin(userAdmin.getNamaAdmin());
        admin.setFotoProfil("default-admin.png");
        admin.setStatus(1);
        admin.setJenisKelamin(userAdmin.getJenisKelamin());
        admin.setNoTelepon(userAdmin.getNoTelepon());
        admin.setTanggalLahir(userAdmin.getTanggalLahir());
        adminService.save(admin);
        //jabatanService.save(jabatan);

        //redirectAttributes.addFlashAttribute("message", "Jabatan berhasil ditambah.");
        return "redirect:/admin/view";
    }
}
