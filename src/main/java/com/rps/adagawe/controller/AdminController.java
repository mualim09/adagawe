package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.UserAdmin;
import com.rps.adagawe.model.*;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/admin")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("total_pelamar", adagaweService.findTotalUserByRole(1));
        model.addAttribute("total_perusahaan", adagaweService.findTotalUserByRole(2));
        model.addAttribute("total_lowongan", adagaweService.findTotalLamaran());

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 1));

        return "/admin/dashboard";
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
        user.setNama(userAdmin.getNamaAdmin());
        user.setFotoProfil("default-admin.png");
        userService.signUpUser(user);

        Admin admin = new Admin();
        admin.setStatus(1);
        admin.setJenisKelamin(userAdmin.getJenisKelamin());
        admin.setNoTelepon(userAdmin.getNoTelepon());
        admin.setTanggalLahir(userAdmin.getTanggalLahir());
        adminService.save(admin);
        //jabatanService.save(jabatan);

        //redirectAttributes.addFlashAttribute("message", "Jabatan berhasil ditambah.");
        return "redirect:/admin/view";
    }

    @GetMapping("/admin/profile")
    public String getViewProfile(Model model) {
        int idAdmin = AdagaweMethods.getAdminBySession(adagaweService).getId();
        Admin admin = adminService.getAdminById(idAdmin);
        model.addAttribute("admin", admin);

        return "/admin/profile/index";
    }

    @GetMapping("/admin/profile/security")
    public String getSecurityAdmin(Model model) {

        UserLogin userLogin = adagaweService.findUserLoginByEmail(AdagaweMethods.getEmailUserBySession());
        model.addAttribute("userLogin", userLogin);
        return "/admin/profile/security";
    }

    @PostMapping("/admin/profile/security")
    public String postSecurityAdmin(@ModelAttribute("userLogin") @Valid UserLogin userLogin, BindingResult result, Model model) {

        //userService.updateUserLogin(userLogin);
        return "/admin/profile/index";
    }

    @GetMapping("/admin/profile/edit")
    public String getEditProfile(Model model) {

        Admin admin = adminService.getAdminById(1);
        model.addAttribute("admin", admin);
        return "/admin/profile/edit";
    }
}
