package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.SertifikatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SertifikatController {

    @Autowired
    SertifikatService sertifikatService;

    @Autowired
    PelamarService pelamarService;

    // Prefix URL
    private final String PREFIX = "/pelamar/sertifikat";
    private final String PREFIX_CREATE = "/pelamar/sertifikat/create";
    private final String PREFIX_EDIT = "/pelamar/sertifikat/edit";
    
    /**
     * Menambah Data Sertifikat
     * @CheckedBy Rifqy
     */
    @GetMapping(PREFIX_CREATE)
    public String create(Model model) {
        model.addAttribute("sertifikat", new Sertifikat());
        return PREFIX_CREATE;
    }

    @PostMapping(PREFIX_CREATE)
    public String postCreate(RedirectAttributes redirectAttributes, @ModelAttribute("sertifikat") @Valid Sertifikat sertifikat,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            return PREFIX_CREATE;
        }

        int idPelamar = AdagaweMethods.getIdPelamarBySession(pelamarService);
        Pelamar pelamar = pelamarService.getPelamarById(idPelamar);
        sertifikat.setPelamar(pelamar);
        sertifikat.setStatus(1);
        sertifikatService.save(sertifikat);

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil ditambah.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }

    /**
     * Mengubah Data Sertifikat
     * @CheckedBy Rifqy
     */
    @GetMapping(PREFIX_EDIT + "/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Sertifikat sertifikat = sertifikatService.getSertifikatById(id);
        model.addAttribute("sertifikat", sertifikat);
        return PREFIX_EDIT;
    }

    @PostMapping(PREFIX_EDIT + "/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                           @ModelAttribute("sertifikat") @Valid Sertifikat sertifikat, BindingResult result, Model model) {

        if (result.hasErrors()) {
            sertifikat.setId(id);
            return PREFIX_EDIT;
        }

        sertifikat.setStatus(1);
        Sertifikat p = sertifikatService.updateSertifikat(id, sertifikat);
        if (p == null) {
            return PREFIX_EDIT;
        }

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil diubah.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }

    /**
     * Ubah Status Sertifikat Menjadi 0 (Tidak Aktif)
     * @CheckedBy Rifqy
     */
    @PostMapping(PREFIX + "/delete/{id}")
    public String deleteSertifikat(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
        Sertifikat data = sertifikatService.deleteSertifikat(id);

        redirectAttributes.addFlashAttribute("message", "Sertifikat berhasil dihapus.");
        return AdagaweConstants.REDIRECT_TO_PELAMAR_PROFILE;
    }
}
