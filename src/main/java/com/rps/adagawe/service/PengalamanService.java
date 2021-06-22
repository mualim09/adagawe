package com.rps.adagawe.service;

import com.rps.adagawe.model.Pendidikan;
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
        pengalaman.setRowStatus(1);
        pengalamanRepository.save(pengalaman);
    }

    public Pengalaman getPengalamanById(Integer id) {
        return pengalamanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pengalaman Id:" + id));
    }

    public Pengalaman updatePengalaman(int id, Pengalaman pengalaman) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);
        assert p != null;

        pengalaman.setId(id);
        pengalaman.setPelamar(p.getPelamar());
        pengalaman.setRowStatus(1);

        pengalamanRepository.save(pengalaman);

        return pengalaman;
    }

    public Pengalaman deletePengalaman(int id, Pengalaman pengalaman) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);

        assert p != null;

        pengalaman.setId(id);
        pengalaman.setPelamar(p.getPelamar());
        pengalaman.setJabatan(p.getJabatan());
        pengalaman.setJenisPegawai(p.getJenisPegawai());
        pengalaman.setNamaPerusahaan(p.getNamaPerusahaan());
        pengalaman.setMulaiKerja(p.getMulaiKerja());
        pengalaman.setTerakhirKerja(p.getTerakhirKerja());
        pengalaman.setDeskripsi(p.getDeskripsi());
        pengalaman.setFileAttachment(p.getFileAttachment());
        pengalaman.setRowStatus(0);
        pengalamanRepository.save(pengalaman);

        return pengalaman;
    }

    public List<Pengalaman> findPengalamanByRowStatus() {

        return (List<Pengalaman>) pengalamanRepository.findPengalamanByRowStatus();
    }
}
