package com.rps.adagawe.service;

import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.repository.PengalamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengalamanService {
    @Autowired
    PengalamanRepository pengalamanRepository;

    public List<Pengalaman> getAll() {
        return (List<Pengalaman>) pengalamanRepository.findAll();
    }

    public void save(Pengalaman pengalaman) {
        pengalamanRepository.save(pengalaman);
    }

    public Pengalaman getPengalamanById(Integer id) {
        return pengalamanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pengalaman Id:" + id));
    }

    public Pengalaman updatePengalaman(int id, Pengalaman pengalaman) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);

        if (p == null) return null;
        p.setJabatan(pengalaman.getJabatan());
        p.setJenisPegawai(pengalaman.getJenisPegawai());
        p.setNamaPerusahaan(pengalaman.getNamaPerusahaan());
        p.setMulaiKerja(pengalaman.getMulaiKerja());
        p.setTerakhirKerja(pengalaman.getTerakhirKerja());
        p.setDeskripsi(pengalaman.getDeskripsi());
        p.setFileAttachment(pengalaman.getFileAttachment());

        pengalamanRepository.save(p);

        return p;
    }

    public Pengalaman deletePengalaman(int id) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);

        if (p == null) return null;

        pengalamanRepository.delete(p);

        return p;
    }
}
