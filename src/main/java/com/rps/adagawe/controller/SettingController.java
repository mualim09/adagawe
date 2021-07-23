package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created on July, 2021
 * @author RPS
 * @status FINAL
 */
@Controller
public class SettingController {

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    UserService userService;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @PostMapping("/account/edit")
    public String postEdit(RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file, @RequestParam("nama") String nama) {

        UserLogin ul = AdagaweMethods.getUserLoginBySession(adagaweService);

        if (nama.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_failed", "Nama tidak boleh kosong.");
            return AdagaweMethods.getRedirectProfil(ul);
        }

        if (file.isEmpty() == false) {
            String folder = AdagaweMethods.getRoleUserLogin(ul);
            String fileName = FileUploadHelper.upload(file, folder);
            ul.setFotoProfil(fileName);
        }

        ul.setNama(nama);
        userService.save(ul);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_success", "Nama berhasil diubah.");
        }
        else {
            redirectAttributes.addFlashAttribute("message_success", "Nama dan Foto Profil berhasil diubah.");
        }

        return AdagaweMethods.getRedirectProfil(ul);
    }

    @PostMapping("/account/security")
    public String postSecurity(RedirectAttributes redirectAttributes, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {

        UserLogin ul = AdagaweMethods.getUserLoginBySession(adagaweService);

        if (password1.isEmpty() || password2.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_failed", "Password tidak boleh kosong.");
            return AdagaweMethods.getRedirectProfil(ul);
        }

        if (bcrypt.matches(password1, ul.getPassword())) {
            String encryptedPassword = bcrypt.encode(password2);
            ul.setPassword(encryptedPassword);
            userService.save(ul);
            redirectAttributes.addFlashAttribute("message_success", "Password berhasil diubah.");
        }
        else {
            redirectAttributes.addFlashAttribute("message_failed", "Password lama tidak sama.");
        }

        return AdagaweMethods.getRedirectProfil(ul);
    }

    @PostMapping("/account/admin/edit")
    public String postAdminEdit(RedirectAttributes redirectAttributes, @ModelAttribute("admin") @Valid Admin admin, BindingResult result) {

        final String redirect = "redirect:/admin/profile";

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message_failed", "Gagal memperbaharui data, data tidak boleh kosong.");
            return redirect;
        }

        Admin myAdmin = AdagaweMethods.getAdminBySession(adagaweService);
        myAdmin.setJenisKelamin(admin.getJenisKelamin());
        myAdmin.setTanggalLahir(admin.getTanggalLahir());
        myAdmin.setNoTelepon(admin.getNoTelepon());

        adagaweService.updateAdmin(myAdmin);
        redirectAttributes.addFlashAttribute("message_success", "Data berhasil diperbaharui.");

        return redirect;
    }

    @PostMapping("/account/pelamar/edit")
    public String postPelamarEdit(RedirectAttributes redirectAttributes, @ModelAttribute("pelamar") @Valid Pelamar pelamar, BindingResult result) {

        final String redirect = "redirect:/pelamar/setting";

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message_failed", "Gagal memperbaharui data, data tidak boleh kosong.");
            return redirect;
        }

        Pelamar myPelamar = AdagaweMethods.getPelamarBySession(adagaweService);
        myPelamar.setTanggalLahir(pelamar.getTanggalLahir());
        myPelamar.setJenisKelamin(pelamar.getJenisKelamin());
        myPelamar.setKota(pelamar.getKota());
        myPelamar.setAlamat(pelamar.getAlamat());
        myPelamar.setNoTelepon(pelamar.getNoTelepon());

        adagaweService.updatePelamar(myPelamar);
        redirectAttributes.addFlashAttribute("message_success", "Data berhasil diperbaharui.");

        return redirect;
    }

    @PostMapping("/account/perusahaan/edit")
    public String postPerusahaanEdit(RedirectAttributes redirectAttributes, @ModelAttribute("perusahaan") @Valid Perusahaan perusahaan, BindingResult result) {

        final String redirect = "redirect:/perusahaan/profile";

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message_failed", "Gagal memperbaharui data, data tidak boleh kosong.");
            return redirect;
        }

        Perusahaan myPerusahaan = AdagaweMethods.getPerusahaanBySession(adagaweService);
        myPerusahaan.setBidangPerusahaan(perusahaan.getBidangPerusahaan());
        myPerusahaan.setProvinsi(perusahaan.getProvinsi());
        myPerusahaan.setKota(perusahaan.getKota());
        myPerusahaan.setAlamatLengkap(perusahaan.getAlamatLengkap());

        adagaweService.updatePerusahaan(myPerusahaan);
        redirectAttributes.addFlashAttribute("message_success", "Data berhasil diperbaharui.");

        return redirect;
    }

    @PostMapping("/account/pelamar/info")
    public String postInformation(RedirectAttributes redirectAttributes, @RequestParam("file_cv") MultipartFile file, @RequestParam("headline") String headline) {

        final String redirect = "redirect:/pelamar/setting";

        if (headline.equals("<p><br></p>") || headline.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_failed", "Headline tidak boleh kosong.");
            return redirect;
        }

        Pelamar myPelamar = AdagaweMethods.getPelamarBySession(adagaweService);

        if (file.isEmpty() == false) {
            String fileName = FileUploadHelper.upload(file, "cv_pelamar");
            myPelamar.setDokumenCv(fileName);
        }

        myPelamar.setHeadline(headline);
        adagaweService.updatePelamar(myPelamar);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_success", "Headline berhasil diubah.");
        }
        else {
            redirectAttributes.addFlashAttribute("message_success", "Headline dan CV berhasil diubah.");
        }

        return redirect;
    }
}