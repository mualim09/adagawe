package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.LamaranService;
import com.rps.adagawe.service.LowonganService;
import com.rps.adagawe.service.PelamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class LowonganController {

    @Autowired
    LowonganService lowonganService;

    @Autowired
    JenisPegawaiService jenisPegawaiService;

    @Autowired
    LamaranService lamaranService;

    @Autowired
    PelamarService pelamarService;

    @Autowired
    AdagaweService adagaweService;

    @GetMapping("/perusahaan/lowongan")
    public String index(Model model, HttpServletRequest request) {

        // Redirect jika belum melengkapi profil
        if (!AdagaweMethods.isPerusahaanExist(adagaweService)) {
            return "redirect:/perusahaan/information";
        }

        Perusahaan obj = AdagaweMethods.getPerusahaanBySession(adagaweService);
        model.addAttribute("lowongans", lowonganService.getLowonganByIdPerusahaan(obj.getId()));

        model.addAttribute("userLogin", obj.getUserLogin());
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/lowongan/index";
    }

    @GetMapping("/perusahaan/lowongan/create")
    public String getCreate(Model model, HttpServletRequest request) {
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("lowongan", new Lowongan());

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/lowongan/create";
    }

    @PostMapping("/perusahaan/lowongan/create")
    public String postCreate(RedirectAttributes redirectAttributes, HttpServletRequest request,
                             @RequestParam(value = "isSalaryHidden", required = false) String sembunyikanGaji,
                             @ModelAttribute("lowongan") @Valid Lowongan lowongan, BindingResult result, Model model) {


        if (result.hasErrors()) {
            model.addAttribute("lowongan", lowongan);
            model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());

            model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
            model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));
            return "/perusahaan/lowongan/create";
        }

        lowongan.setIdPerusahaan(AdagaweMethods.getPerusahaanBySession(adagaweService).getId());
        lowongan.setSembunyikanGaji(sembunyikanGaji != null ? 1 : 0);
        lowongan.setCreatedDate(new Date());
        lowongan.setLastModified(new Date());
        lowongan.setStatus(1);
        lowonganService.save(lowongan);

        redirectAttributes.addFlashAttribute("message", "Lowongan berhasil ditambah.");
        return "redirect:/perusahaan/lowongan";
    }

    @GetMapping("/perusahaan/lowongan/edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());
        model.addAttribute("lowongan", lowonganService.getLowonganById(id));

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/lowongan/edit";
    }

    @PostMapping("/perusahaan/lowongan/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id,
                           @RequestParam(value = "isSalaryHidden", required = false) String sembunyikanGaji,
                           HttpServletRequest request, @ModelAttribute("lowongan") @Valid Lowongan lowongan, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("lowongan", lowongan);
            model.addAttribute("jenisPegawais", jenisPegawaiService.findJenisPegawaiByRowStatus());

            model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
            model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));
            return "/perusahaan/lowongan/edit";
        }

        lowongan.setIdPerusahaan(AdagaweMethods.getPerusahaanBySession(adagaweService).getId());
        lowongan.setSembunyikanGaji(sembunyikanGaji != null ? 1 : 0);

        lowonganService.updateLowongan(id, lowongan);

        redirectAttributes.addFlashAttribute("message", "Lowongan berhasil diubah.");
        return "redirect:/perusahaan/lowongan";
    }

    @GetMapping("/perusahaan/lowongan/view/{id}")
    public String getView(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {

        model.addAttribute("userLogin", AdagaweMethods.getUserLoginBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/lowongan/view";
    }

    @GetMapping("/perusahaan/lowongan/detail/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        Lowongan lowongan = lowonganService.getLowonganById(id);
        int lowonganId = lowongan.getId();
        model.addAttribute("lowongan", lowongan);
        model.addAttribute("lamarans1", pelamarService.getPelamarByIdLowongan(lowonganId, 0, 1));
        model.addAttribute("lamarans2", pelamarService.getPelamarByIdLowongan(lowonganId, 2, 3));
        model.addAttribute("lamarans3", pelamarService.getPelamarByIdLowongan(lowonganId, 4, 5));
        model.addAttribute("lamarans4", pelamarService.getPelamarByIdLowongan(lowonganId, 6, 6));

        model.addAttribute("perusahaan", AdagaweMethods.getPerusahaanBySession(adagaweService));
        model.addAttribute("url", AdagaweMethods.getMainUrl(request, 2));

        return "/perusahaan/lowongan/detail";
    }

    @GetMapping("/perusahaan/lowongan/delete/{id}")
    public String getDelete(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, Model model, HttpServletRequest request) {
        Lowongan lowongan = lowonganService.getLowonganById(id);
        lowongan.setStatus(0);
        lowonganService.save(lowongan);

        redirectAttributes.addFlashAttribute("message_success", "Lowongan berhasil ditutup.");

        return "redirect:/perusahaan/lowongan";
    }
}
