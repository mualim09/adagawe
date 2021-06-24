package com.rps.adagawe.helper;

import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.AdminService;
import com.rps.adagawe.service.PelamarService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created on June, 2021
 * @author RPS
 */

public class AdagaweMethods {

    public static int getIdPelamarBySession(PelamarService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        int idPelamar = service.findPelamarByUserLogin(ul.getId()).getId();

        return idPelamar;
    }

    public static String getEmailUserBySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

    public static int getIdAdminBySession(AdminService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        int idAdmin= service.getAdminById(ul.getId()).getId();

        return idAdmin;
    }
}
