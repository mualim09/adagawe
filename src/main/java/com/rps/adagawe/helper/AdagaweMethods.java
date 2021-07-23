package com.rps.adagawe.helper;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.PerusahaanService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on June, 2021
 * @author RPS
 */
@Controller
public class AdagaweMethods {

    public static String getEmailUserBySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public static UserLogin getUserLoginBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return service.findUserLoginByEmail(authentication.getName());
    }

    public static Admin getAdminBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());

        return service.findAdminByUserLogin(ul.getId());
    }

    public static Pelamar getPelamarBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());

        return service.findPelamarByUserLogin(ul.getId());
    }

    public static Perusahaan getPerusahaanBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());

        return service.findPerusahaanByUserLogin(ul.getId());
    }

    public static UserLogin getUserLoginByEmail(AdagaweService service, String email) {

        return service.findUserLoginByEmail(email);
    }

    public static boolean isPerusahaanExist(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        Perusahaan perusahaan = service.findPerusahaanByUserLogin(ul.getId());

        return perusahaan != null ? true : false;
    }

    public static String getMainUrl(HttpServletRequest request, int index) {
        /**
         * Url = /pelamar/profile
         * [0] = NULL
         * [1] = pelamar
         * [2] = profile
         */
        String url = request.getRequestURI();
        String[] words = url.split("[/]");

        return words[index];
    }

    public static String getRoleUserLogin(UserLogin userLogin) {
        if (userLogin.getUserRole().name() == "Admin") {
            return "foto_profil";
        }
        if (userLogin.getUserRole().name() == "Pelamar") {
            return "foto_profil";
        }
        else {
            return "foto_perusahaan";
        }
    }

    public static String getRedirectProfil(UserLogin userLogin) {
        if (userLogin.getUserRole().name() == "Admin") {
            return "redirect:/admin/profile";
        }
        if (userLogin.getUserRole().name() == "Pelamar") {
            return "redirect:/pelamar/profile";
        }
        else {
            return "redirect:/perusahaan/profile";
        }
    }
}
