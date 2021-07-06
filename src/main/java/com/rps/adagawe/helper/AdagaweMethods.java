package com.rps.adagawe.helper;

import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.PerusahaanService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on June, 2021
 * @author RPS
 */

public class AdagaweMethods {

    public static String getEmailUserBySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public static int getIdAdminBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        int idAdmin= service.findAdminByUserLogin(ul.getId()).getId();

        return idAdmin;
    }

    public static int getIdPelamarBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        int idPelamar = service.findPelamarByUserLogin(ul.getId()).getId();

        return idPelamar;
    }

    public static int getIdPerusahaanBySession(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        int idPelamar = service.findPelamarByUserLogin(ul.getId()).getId();

        return idPelamar;
    }

    public static String getMainUrl(HttpServletRequest request) {
        /**
         * Url = /pelamar/profile
         * [0] = NULL
         * [1] = pelamar
         * [2] = profile
         */
        String url = request.getRequestURI();
        String[] words = url.split("[/]");

        return words[2];
    }
}
