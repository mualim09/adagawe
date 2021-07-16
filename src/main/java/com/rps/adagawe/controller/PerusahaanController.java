package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.*;
import com.rps.adagawe.service.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PerusahaanController {

    @Autowired
    PerusahaanService perusahaanService;

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    VerifikasiPerusahaanService verifikasiPerusahaanService;

    @GetMapping("/admin/perusahaan")
    public String index(Model model) {
        List<Perusahaan> perusahaans = perusahaanService.findPerusahaanByRowStatus();
        model.addAttribute("perusahaans", perusahaans);
        return "/admin/perusahaan/index";
    }

    @GetMapping("/perusahaan/verifikasi/create")
    public String create(Model model) {
        model.addAttribute("perusahaanObject", new Perusahaan());
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        return "/perusahaan/verifikasi/create";
    }

    @PostMapping("/perusahaan/verifikasi/create")
    public String postCreate(RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file,
                             @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/perusahaan/verifikasi/create";
        }

        UserLogin ul = AdagaweMethods.getUserLoginBySession(adagaweService);

        perusahaan.setIdUserLogin(ul.getId());

        if (file.isEmpty()){
            perusahaan.setFotoProfil("default.jpg");
        } else {
            String fileName = FileUploadHelper.upload(file, "foto_perusahaan");
            perusahaan.setFotoProfil(fileName);
        }
        perusahaanService.save(perusahaan);

        //redirectAttributes.addFlashAttribute("message", "Perusahaan berhasil ditambah.");
        return "redirect:/perusahaan/verifikasi/createnext";
    }


    @GetMapping("/perusahaan")
    public String getIndex(Model model, HttpServletRequest request) {

        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 1));

        return "/perusahaan/dashboard";
    }

    @GetMapping("/perusahaan/view")
    public String getViewPerusahaan(Model model, HttpServletRequest request) {

        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/index";
    }

    @GetMapping("/perusahaan/profile/edit")
    public String getEditPerusahaan(Model model, HttpServletRequest request) {

        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/profile/edit";
    }

    @GetMapping("/perusahaan/profile/security")
    public String getSecurityPerusahaan(Model model, HttpServletRequest request) {
        UserLogin userLogin = adagaweService.findUserLoginByEmail(AdagaweMethods.getEmailUserBySession());
        model.addAttribute("userLogin", userLogin);

        return "/perusahaan/profile/security";
    }

    @GetMapping("/perusahaan/profile")
    public String profile(Model model) {
        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("userlogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        UserLogin idUserLogin = AdagaweMethods.getUserLoginBySession(adagaweService);
        List<Integer> perusahaan = perusahaanService.getIdUserLoginInPerusahaan();
        String prefix;


        if (perusahaan.contains(idUserLogin.getId()))
        {
            Perusahaan perusahaan1 = AdagaweMethods.getPerusahaanBySession(adagaweService);
            VerifikasiPerusahaan verifikasiperusahaan = verifikasiPerusahaanService.getLastIdPerusahaan(perusahaan1.getId());

            model.addAttribute("verifikasiperusahaan", verifikasiperusahaan);
            prefix = "/perusahaan/profile/index";
        }else{
            prefix = "/perusahaan/profile/create";
        }
        return prefix;
    }
}
