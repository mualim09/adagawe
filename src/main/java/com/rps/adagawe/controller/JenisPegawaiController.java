package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.service.JabatanService;
import com.rps.adagawe.service.JenisPegawaiService;
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
public class JenisPegawaiController {

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/admin/jenispegawai")
    public String getIndex(Model model, HttpServletRequest request) {
        List<JenisPegawai> jenisPegawais = jenisPegawaiService.findJenisPegawaiByRowStatus();
        model.addAttribute("jenisPegawais", jenisPegawais);

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jenispegawai/index";
    }

    @GetMapping("/admin/jenispegawai/create")
    public String getCreate(Model model, HttpServletRequest request) {
        model.addAttribute("jenispegawai", new JenisPegawai());

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jenispegawai/create";
    }

    @PostMapping("/admin/jenispegawai/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
            return "/admin/jenispegawai/create";
        }

        jenisPegawaiService.save(jenispegawai);

        redirectAttributes.addFlashAttribute("message", "Jenis Pegawai berhasil ditambah.");
        return "redirect:/admin/jenispegawai";
    }


    @GetMapping("/admin/jenispegawai/edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        model.addAttribute("jenispegawai", jenisPegawaiService.getJenisPegawaiById(id));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/admin/jenispegawai/edit";
    }

    @PostMapping("/admin/jenispegawai/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        if (result.hasErrors()) {
            jenispegawai.setId(id);
            return "/admin/jenispegawai/edit";
        }

        JenisPegawai p = jenisPegawaiService.updateJenisPegawai(id, jenispegawai);
        if (p == null) {
            return "/admin/jenispegawai/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Jenis Pegawai berhasil diubah.");
        return "redirect:/admin/jenispegawai";
    }

    @PostMapping("/admin/jenispegawai/delete/{id}")
    public String deleteJenisPegawai(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        JenisPegawai p = jenisPegawaiService.deleteJenisPegawai(id, jenispegawai);

        redirectAttributes.addFlashAttribute("message", "JenisPegawai berhasil dihapus.");
        return "redirect:/admin/jenispegawai";
    }
}
