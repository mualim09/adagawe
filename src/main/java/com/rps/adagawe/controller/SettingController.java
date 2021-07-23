package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            redirectAttributes.addFlashAttribute("message_failed", "Nama Perusahaan Tidak Boleh Kosong.");
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
            redirectAttributes.addFlashAttribute("message_success", "Nama Berhasil diubah.");
        }
        else {
            redirectAttributes.addFlashAttribute("message_success", "Nama dan Foto Profil Berhasil diubah.");
        }

        return AdagaweMethods.getRedirectProfil(ul);
    }

    @PostMapping("/account/security")
    public String postSecurity(RedirectAttributes redirectAttributes, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {

        UserLogin ul = AdagaweMethods.getUserLoginBySession(adagaweService);

        if (password1.isEmpty() || password2.isEmpty()) {
            redirectAttributes.addFlashAttribute("message_failed", "Password Tidak Boleh Kosong.");
            return AdagaweMethods.getRedirectProfil(ul);
        }

        if (bcrypt.matches(password1, ul.getPassword())) {
            String encryptedPassword = bcrypt.encode(password2);
            ul.setPassword(encryptedPassword);
            userService.save(ul);
            redirectAttributes.addFlashAttribute("message_success", "Password Berhasil diubah.");
        }
        else {
            redirectAttributes.addFlashAttribute("message_failed", "Password Lama tidak sama.");
        }


        return AdagaweMethods.getRedirectProfil(ul);
    }
}
