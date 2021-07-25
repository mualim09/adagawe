package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.service.*;
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

    @GetMapping("/admin/profile")
    public String getProfile(Model model, HttpServletRequest request) {

        model.addAttribute("admin", AdagaweMethods.getAdminBySession(adagaweService));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/profile/index";
    }

//    @GetMapping("/admin/create")
//    public String getCreate(Model model) {
//        model.addAttribute("userAdmin", new UserAdmin());
//
//        return "/admin/create";
//    }
//
//    @PostMapping("/admin/create")
//    public String postCreate(RedirectAttributes redirectAttributes,
//                             @ModelAttribute("userAdmin") @Valid UserAdmin userAdmin, BindingResult result, Model model) {
//
//        if (result.hasErrors()) {
//            return "/admin/create";
//        }
//
//        UserLogin user = new UserLogin();
//        user.setEmail(userAdmin.getEmail());
//        user.setPassword(userAdmin.getPassword());
//        user.setUserRole(UserRole.Admin);
//        user.setNama(userAdmin.getNamaAdmin());
//        user.setFotoProfil("default-admin.png");
//        userService.signUpUser(user);
//
//        Admin admin = new Admin();
//        admin.setStatus(1);
//        admin.setJenisKelamin(userAdmin.getJenisKelamin());
//        admin.setNoTelepon(userAdmin.getNoTelepon());
//        admin.setTanggalLahir(userAdmin.getTanggalLahir());
//        adminService.save(admin);
//
//        //redirectAttributes.addFlashAttribute("message", "Jabatan berhasil ditambah.");
//        return "redirect:/admin/view";
//    }
}
