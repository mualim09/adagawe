package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.service.JabatanService;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.LowonganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LowonganController {

    @Autowired
    LowonganService lowonganService;

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @GetMapping("/perusahaan/lowongan")
    public String index(Model model, HttpServletRequest request) {
        List<Lowongan> lowongans = lowonganService.getAll();
        model.addAttribute("lowongans", lowongans);

        model.addAttribute("url", AdagaweMethods.getMainUrl(request));
        return "/lowongan/index";
    }

    @GetMapping("/perusahaan/lowongan/create")
    public String getCreate(Model model, HttpServletRequest request) {
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("lowongan", new Lowongan());

        model.addAttribute("url", AdagaweMethods.getMainUrl(request));
        return "/lowongan/create";
    }
}
