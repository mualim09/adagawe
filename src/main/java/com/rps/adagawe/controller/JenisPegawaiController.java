package com.rps.adagawe.controller;

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

import javax.validation.Valid;
import java.util.List;

@Controller
public class JenisPegawaiController {
    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @GetMapping("/jenispegawai")
    public String index(Model model) {
        List<JenisPegawai> jenisPegawais = jenisPegawaiService.findJenisPegawaiByRowStatus();
        model.addAttribute("jenisPegawais", jenisPegawais);
        return "/jenispegawai/index";
    }

    @GetMapping("/jenispegawai/create")
    public String create(Model model) {
        model.addAttribute("jenispegawai", new JenisPegawai());
        return "/jenispegawai/create";
    }

    @PostMapping("/jenispegawai/create")
    public String postCreate(RedirectAttributes redirectAttributes,
                             @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/jenispegawai/create";
        }

        jenisPegawaiService.save(jenispegawai);

        redirectAttributes.addFlashAttribute("message", "Jenis Pegawai berhasil ditambah.");
        return "redirect:/jenispegawai";
    }


    @GetMapping("/jenispegawai/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        JenisPegawai jenispegawai = jenisPegawaiService.getJenisPegawaiById(id);

        model.addAttribute("jenispegawai", jenispegawai);
        return "/jenispegawai/edit";
    }

    @PostMapping("/jenispegawai/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        if (result.hasErrors()) {
            jenispegawai.setId(id);
            return "/jenispegawai/edit";
        }

        JenisPegawai p = jenisPegawaiService.updateJenisPegawai(id, jenispegawai);
        if (p == null) {
            return "/jenispegawai/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Jenis Pegawai berhasil diubah.");
        return "redirect:/jenispegawai";
    }

    @PostMapping("/jenispegawai/delete/{id}")
    public String deleteJenisPegawai(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                                @ModelAttribute("jenispegawai") @Valid JenisPegawai jenispegawai, BindingResult result, Model model) {

        JenisPegawai p = jenisPegawaiService.deleteJenisPegawai(id, jenispegawai);

        redirectAttributes.addFlashAttribute("message", "JenisPegawai berhasil dihapus.");
        return "redirect:/jenispegawai";
    }
}
