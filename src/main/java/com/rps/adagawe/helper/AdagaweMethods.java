package com.rps.adagawe.helper;

import com.rps.adagawe.model.*;
import com.rps.adagawe.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    public static boolean isPelamarExist(AdagaweService service) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLogin ul = service.findUserLoginByEmail(authentication.getName());
        Pelamar pelamar = service.findPelamarByUserLogin(ul.getId());

        return pelamar != null ? true : false;
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
            return "redirect:/pelamar/setting";
        }
        else {
            return "redirect:/perusahaan/profile";
        }
    }

    public static List<VerifikasiPerusahaan> filterVerifikasiPerusahaan(List<VerifikasiPerusahaan> perusahaans, int hasil) {
        List<VerifikasiPerusahaan> myList = new ArrayList<>();

        for (VerifikasiPerusahaan perusahaan : perusahaans) {
            if (perusahaan.getHasil() == hasil) {
                myList.add(perusahaan);
            }
        }

        return myList;
    }

    public static List<Lowongan> filterLowongan(List<Lowongan> lowongans, int hasil) {
        List<Lowongan> myList = new ArrayList<>();

        for (Lowongan lowongan: lowongans) {
            if (lowongan.getStatus() == hasil) {
                myList.add(lowongan);
            }
        }

        return myList;
    }

    public static Integer filterLowonganJenisPegawai(List<Lowongan> lowongans, int id) {
        List<Lowongan> myList = new ArrayList<>();

        for (Lowongan lowongan : lowongans) {
            if (lowongan.getJenisPegawai().getId() == id) {
                myList.add(lowongan);
            }
        }

        return myList.size();
    }

    public static Integer filterLamaran(List<Lamaran> lamarans, int id) {
        List<Lamaran> myList = new ArrayList<>();

        for (Lamaran lamaran :  lamarans) {
            if (lamaran.getLowongan().getPerusahaan().getId() == id) {
                myList.add(lamaran);
            }
        }

        return myList.size();
    }

    public static Map<String, Integer> getBarChartVerifikasi(VerifikasiPerusahaanService service) {
        List<VerifikasiPerusahaan> myList = service.getAll();
        Map<String, Integer> graphData = new TreeMap<>();

        graphData.put("Menunggu Verifikasi", AdagaweMethods.filterVerifikasiPerusahaan(myList, 0).size());
        graphData.put("Terverifikasi", AdagaweMethods.filterVerifikasiPerusahaan(myList, 1).size());
        graphData.put("Verifikasi Ditolak", AdagaweMethods.filterVerifikasiPerusahaan(myList, 2).size());

        return graphData;
    }

    public static Map<String, Integer> getBarChartLamaran(LamaranService lService, PerusahaanService pService, int id) {
        List<Lamaran> myList = lService.getLamaranByIdPelamar(id);
        List<Perusahaan> listP = pService.getAll();
        Map<String, Integer> graphData = new TreeMap<>();

        for (int i = 0; i < myList.size(); i++) {
            int value = AdagaweMethods.filterLamaran(myList, listP.get(i).getId());
            if (value > 0) {
                graphData.put(listP.get(i).getUserLogin().getNama(), value);
            }
        }

        return graphData;
    }

    public static Map<String, Integer> getBarChartJenisPegawai(JenisPegawaiService jpService, LowonganService lService) {
        List<JenisPegawai> listJp = jpService.getAll();
        List<Lowongan> myList = lService.getAllData();
        Map<String, Integer> graphData = new TreeMap<>();

        for (int i = 0; i < listJp.size(); i++) {
            int value = AdagaweMethods.filterLowonganJenisPegawai(myList, listJp.get(i).getId());
            if (value > 0) {
                graphData.put(listJp.get(i).getNamajenisPegawai(), value);
            }
        }

        return graphData;
    }

    public static Map<String, Integer> getBarChartJenisPegawaiByPerusahaan(JenisPegawaiService jpService, LowonganService lService, int id) {
        List<JenisPegawai> listJp = jpService.getAll();
        Map<String, Integer> graphData = new TreeMap<>();
        List<Lowongan> myList = lService.getLowonganByIdPerusahaan(id);

        for (int i = 0; i < listJp.size(); i++) {
            int value = AdagaweMethods.filterLowonganJenisPegawai(myList, listJp.get(i).getId());
            if (value > 0) {
                graphData.put(listJp.get(i).getNamajenisPegawai(), value);
            }
        }

        return graphData;
    }
}
