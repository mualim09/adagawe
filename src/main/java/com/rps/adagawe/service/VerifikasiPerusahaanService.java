package com.rps.adagawe.service;

import com.rps.adagawe.helper.AdagaweMethods;
import com.rps.adagawe.helper.AdagaweService;
import com.rps.adagawe.model.*;
import com.rps.adagawe.repository.VerifikasiPerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VerifikasiPerusahaanService {

    @Autowired
    VerifikasiPerusahaanRepository verifikasiPerusahaanRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    AdagaweService adagaweService;

    public List<VerifikasiPerusahaan> getAll() {
        return (List<VerifikasiPerusahaan>) verifikasiPerusahaanRepository.findAll();
    }

    public Perusahaan findLastIdInt(){
        Perusahaan ab = new Perusahaan();
        int idPerusahaan = AdagaweMethods.getIdPerusahaanBySession(adagaweService);
        ab.setId(idPerusahaan);

        return ab;
    }

    public VerifikasiPerusahaan getLastIdPerusahaan(Integer id) {
        return verifikasiPerusahaanRepository.findLastIdPerusahaan(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid perusahaan Id:" + id));
    }

    public List<VerifikasiPerusahaan> getListVerifikasiPerusahaanById(int idPerusahaan) {
        return verifikasiPerusahaanRepository.findIdPerusahaan(idPerusahaan);
    }

    public VerifikasiPerusahaan getVerifikasiPerusahaanById(Integer id) {
        return verifikasiPerusahaanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid perusahaan Id:" + id));
    }

    public void savenext(VerifikasiPerusahaan verifikasiPerusahaan) {
        Date date = new Date();

        verifikasiPerusahaan.setPerusahaan(findLastIdInt());
        verifikasiPerusahaan.setHasil(0);
        verifikasiPerusahaan.setCreatedDate(date);
        verifikasiPerusahaan.setLastModified(date);
        verifikasiPerusahaanRepository.save(verifikasiPerusahaan);
    }

    public VerifikasiPerusahaan setujuiVerifikasi(int id, VerifikasiPerusahaan verifikasiPerusahaan) {

        VerifikasiPerusahaan p = verifikasiPerusahaanRepository.findById(id).orElse(null);
        String nama = AdagaweMethods.getNameAdminBySession(adminService);

        assert p != null;

        verifikasiPerusahaan.setId(id);
        verifikasiPerusahaan.setPerusahaan(p.getPerusahaan());
        verifikasiPerusahaan.setNpwp(p.getNpwp());
        verifikasiPerusahaan.setSiu(p.getSiu());
        verifikasiPerusahaan.setTdp(p.getTdp());
        verifikasiPerusahaan.setHasil(1);
        verifikasiPerusahaan.setCreatedDate(p.getCreatedDate());
        verifikasiPerusahaan.setLastModified(p.getLastModified());
        verifikasiPerusahaan.setDiverifikasiOleh(nama);

        verifikasiPerusahaanRepository.save(verifikasiPerusahaan);

        return verifikasiPerusahaan;
    }

    public VerifikasiPerusahaan tolakVerifikasi(int id, VerifikasiPerusahaan verifikasiPerusahaan) {

        VerifikasiPerusahaan p = verifikasiPerusahaanRepository.findById(id).orElse(null);
        String nama = AdagaweMethods.getNameAdminBySession(adminService);

        assert p != null;

        verifikasiPerusahaan.setId(id);
        verifikasiPerusahaan.setPerusahaan(p.getPerusahaan());
        verifikasiPerusahaan.setNpwp(p.getNpwp());
        verifikasiPerusahaan.setSiu(p.getSiu());
        verifikasiPerusahaan.setTdp(p.getTdp());
        verifikasiPerusahaan.setHasil(2);
        verifikasiPerusahaan.setCreatedDate(p.getCreatedDate());
        verifikasiPerusahaan.setLastModified(p.getLastModified());
        verifikasiPerusahaan.setDiverifikasiOleh(nama);

        verifikasiPerusahaanRepository.save(verifikasiPerusahaan);

        return verifikasiPerusahaan;
    }
}