package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.UserAdmin;
import com.rps.adagawe.model.*;
import com.rps.adagawe.rest.ChartController;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    JenisPegawaiService jenisPegawaiService;

    @Autowired
    LowonganService lowonganService;

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    VerifikasiPerusahaanService verifikasiPerusahaanService;

    @GetMapping("/admin")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("total_pengguna", adagaweService.findTotalUser());
        model.addAttribute("total_pelamar", adagaweService.findTotalUserByRole(1));
        model.addAttribute("total_perusahaan", adagaweService.findTotalUserByRole(2));
        model.addAttribute("total_lowongan", adagaweService.findTotalLowongan());

        Map<String, Integer> barData = AdagaweMethods.getBarChartVerifikasi(verifikasiPerusahaanService);
        model.addAttribute("verify", barData.get("Menunggu Verifikasi") > 0 ? true : false);
        model.addAttribute("data_verifikasi", barData);
        model.addAttribute("data_jenis_pegawai", AdagaweMethods.getBarChartJenisPegawai(jenisPegawaiService, lowonganService));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 1));

        return "/admin/dashboard";
    }

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
