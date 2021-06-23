package com.rps.adagawe.service;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.repository.PelamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelamarService {

    @Autowired
    PelamarRepository pelamarRepository;

    public List<Pelamar> getAll() {
        return (List<Pelamar>) pelamarRepository.findAll();
    }

    public void save(Pelamar pengalaman) {
        pelamarRepository.save(pengalaman);
    }

    public Pelamar getPelamarById(Integer id) {
        return pelamarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pengalaman Id:" + id));
    }

    public Pelamar updatePelamar(int id, Pelamar pengalaman) {
        Pelamar p = pelamarRepository.findById(id).orElse(null);

        if (p == null) return null;
//        p.setJabatan(pengalaman.getJabatan());
//        p.setJenisPegawai(pengalaman.getJenisPegawai());
//        p.setNamaPerusahaan(pengalaman.getNamaPerusahaan());
//        p.setMulaiKerja(pengalaman.getMulaiKerja());
//        p.setTerakhirKerja(pengalaman.getTerakhirKerja());
//        p.setDeskripsi(pengalaman.getDeskripsi());
//        p.setFileAttachment(pengalaman.getFileAttachment());

        pelamarRepository.save(p);

        return p;
    }

    public Pelamar deletePelamar(int id) {
        Pelamar p = pelamarRepository.findById(id).orElse(null);

        if (p == null) return null;

        pelamarRepository.delete(p);

        return p;
    }

    public UserLogin findUserLoginByEmail(String email) {
        return (UserLogin) pelamarRepository.getIdUserLoginByEmail(email);
    }

    public Pelamar findPelamarByUserLogin(int userId) {
        return pelamarRepository.getPelamarByUserLogin(userId);
    }
}
