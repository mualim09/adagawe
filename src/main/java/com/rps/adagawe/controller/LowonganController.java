package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.LowonganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
        return "/perusahaan/lowongan/index";
    }

    @GetMapping("/perusahaan/lowongan/create")
    public String getCreate(Model model, HttpServletRequest request) {
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("lowongan", new Lowongan());

        model.addAttribute("url", AdagaweMethods.getMainUrl(request));
        return "/perusahaan/lowongan/create";
    }

    @PostMapping("/perusahaan/lowongan/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("lowongan") @Valid Lowongan lowongan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/perusahaan/lowongan/create";
        }

        lowonganService.save(lowongan);

        redirectAttributes.addFlashAttribute("message", "Lowongan berhasil ditambah.");
        return "redirect:/perusahaan/lowongan";
    }

    @GetMapping("/perusahaan/lowongan/edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("lowongan", lowonganService.getLowonganById(id));

        model.addAttribute("url", AdagaweMethods.getMainUrl(request));
        return "/perusahaan/lowongan/edit";
    }

    @GetMapping("/perusahaan/lowongan/view/{id}")
    public String getView(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {

        return "/perusahaan/lowongan/view";
    }

    @GetMapping("/perusahaan/lowongan/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        Lowongan lowongan = lowonganService.getLowonganById(id);
        model.addAttribute("lowongan", lowongan);
        //model.addAttribute("jenisPegawai", jenisPegawai);

        return "/perusahaan/lowongan/detail";
    }
}
