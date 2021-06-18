package com.rps.adagawe.controller;

import com.rps.adagawe.helper.FileUploadHelper;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.service.JabatanService;
import com.rps.adagawe.service.JenisPegawaiService;
import com.rps.adagawe.service.PelamarService;
import com.rps.adagawe.service.PengalamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PengalamanController {
    @Autowired
    PengalamanService pengalamanService;

    @Autowired
    PelamarService pelamarService;

    @Autowired
    JabatanService jabatanService;

    @Autowired
    JenisPegawaiService jenisPegawaiService;


    @GetMapping("/pengalaman")
    public String index(Model model) {
        List<Pengalaman> pengalamans = pengalamanService.getAll();
        model.addAttribute("pengalamans", pengalamans);
        return "/pengalaman/index";
    }

    @GetMapping("/pengalaman/create")
    public String create(Model model) {
        model.addAttribute("jabatans", jabatanService.getAll());
        model.addAttribute("jenisPegawais", jenisPegawaiService.getAll());
        model.addAttribute("pengalaman", new Pengalaman());
        return "/pengalaman/create";
    }

    @PostMapping("/pengalaman/create")
    public String postCreate(RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file,
                             @ModelAttribute("pengalaman") @Valid Pengalaman pengalaman, BindingResult result, Model model) {
        if (pengalaman.getJabatan().getId() == null) {
            System.out.println("ID Jabatan null");

//            result.addError();
        }

        if (result.hasErrors()) {
            System.out.println("Error");
            result.getAllErrors();
            return "/pengalaman/create";
        }
        String fileName = FileUploadHelper.Upload(file);
        Pelamar pelamar = pelamarService.getPelamarById(1);
        pengalaman.setPelamar(pelamar);
        pengalaman.setFileAttachment(fileName);
        pengalamanService.save(pengalaman);

        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil ditambah.");
        return "redirect:/pengalaman";
    }


    @GetMapping("/pengalaman/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Pengalaman pengalaman = pengalamanService.getPengalamanById(id);
        model.addAttribute("pengalamanObject", pengalaman);
        return "/pengalaman/edit";
    }

    @PostMapping("/pengalaman/edit/{id}")
    public String postEdit(RedirectAttributes redirectAttributes, @PathVariable("id") int id,
                               @ModelAttribute("pengalamanObject") @Valid Pengalaman pengalaman, BindingResult result) {
        if (result.hasErrors()) {
            pengalaman.setId(id);
            return "/pengalaman/edit";
        }

        Pengalaman emp = pengalamanService.updatePengalaman(id, pengalaman);
        if (emp == null) {
            return "/pengalaman/edit";
        }

        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil diubah.");
        return "redirect:/pengalaman";
    }

    @PostMapping("/pengalaman/delete/{id}")
    public String deletePengalaman(RedirectAttributes redirectAttributes, @PathVariable("id") int id) {
        Pengalaman emp = pengalamanService.deletePengalaman(id);


        redirectAttributes.addFlashAttribute("message", "Pengalaman berhasil dihapus.");
        return "redirect:/pengalaman";
    }
}
