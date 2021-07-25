package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created on June, 2021
 * @author RPS
 * @status FINAL
 */
@Controller
public class DashboardController {

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @Autowired
    LowonganService lowonganService;

    @Autowired
    AdagaweService adagaweService;

    @Autowired
    VerifikasiPerusahaanService verifikasiPerusahaanService;

    @Autowired
    PerusahaanService perusahaanService;

    @Autowired
    LamaranService lamaranService;

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

    @GetMapping("/perusahaan")
    public String getIndex(Model model, HttpServletRequest request) {

        // Redirect jika belum melengkapi profil
        if (!AdagaweMethods.isPerusahaanExist(adagaweService)) {
            return "redirect:/perusahaan/information";
        }

        Perusahaan data = AdagaweMethods.getPerusahaanBySession(adagaweService);
        List<Lowongan> lowongans = lowonganService.getLowonganByIdPerusahaan(data.getId());
        model.addAttribute("total_lowongan_aktif", AdagaweMethods.filterLowongan(lowongans, 1).size());
        model.addAttribute("total_lowongan_tutup", AdagaweMethods.filterLowongan(lowongans, 0).size());
        model.addAttribute("total_lowongan", lowongans.size());
        model.addAttribute("verify", true);
        model.addAttribute("data_jenis_pegawai", AdagaweMethods.getBarChartJenisPegawaiByPerusahaan(jenisPegawaiService, lowonganService, data.getId()));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 1));

        return "/perusahaan/dashboard";
    }

    @GetMapping("/pelamar/dashboard")
    public String getDashboard(Model model, HttpServletRequest request) {

        // Redirect jika belum melengkapi profil
        if (!AdagaweMethods.isPelamarExist(adagaweService)) {
            return "redirect:/pelamar/information";
        }

        Pelamar pelamar = AdagaweMethods.getPelamarBySession(adagaweService);
        model.addAttribute("total_lamaran", lamaranService.getLamaranByIdPelamar(pelamar.getId()).size());
        model.addAttribute("total_perusahaan", lamaranService.getCountLamaranPerusahaanByPelamar(pelamar.getId()));
        model.addAttribute("data_lamaran", AdagaweMethods.getBarChartLamaran(lamaranService, perusahaanService, pelamar.getId()));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/pelamar/dashboard";
    }
}
