package com.rps.adagawe.service;

import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.repository.LowonganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LowonganService {

    @Autowired
    LowonganRepository lowonganRepository;

    public List<Lowongan> getAll() {
        return (List<Lowongan>) lowonganRepository.getLowonganByStatus();
    }

    public Lowongan getLowonganById(Integer id) {
        return lowonganRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Lowongan Id:" + id));
    }

    public List<Lowongan> getLowonganByIdPerusahaan(Integer id) {
        return lowonganRepository.getLowonganByIdPerusahaanDesc(id);
    }

    public void save(Lowongan lowongan) {
        lowonganRepository.save(lowongan);
    }

    public void updateLowongan(int id, Lowongan lowongan) {
        Lowongan l = lowonganRepository.findById(id).orElse(null);

        if (l != null) {
            l.setId(id);
            l.setIdPerusahaan(lowongan.getIdPerusahaan());
            l.setIdJenisPegawai(lowongan.getIdJenisPegawai());
            l.setJudulLowongan(lowongan.getJudulLowongan());
            l.setKeterangan(lowongan.getKeterangan());
            l.setJenjangMinimal(lowongan.getJenjangMinimal());
            l.setGajiMinimal(lowongan.getGajiMinimal());
            l.setGajiMaksimal(lowongan.getGajiMaksimal());
            l.setPengalamanKerja(lowongan.getPengalamanKerja());
            l.setKeahlian(lowongan.getKeahlian());
            l.setSembunyikanGaji(lowongan.getSembunyikanGaji());
            l.setLastModified(new Date());
        }

        lowonganRepository.save(l);
    }
}
