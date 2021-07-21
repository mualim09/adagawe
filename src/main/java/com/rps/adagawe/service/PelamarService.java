package com.rps.adagawe.service;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.LamaranPelamar;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.repository.LamaranPelamarRepository;
import com.rps.adagawe.repository.PelamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelamarService {

    @Autowired
    PelamarRepository pelamarRepository;

    @Autowired
    LamaranPelamarRepository lamaranPelamarRepository;

    public List<Pelamar> getAll() {
        return (List<Pelamar>) pelamarRepository.findAll();
    }

    public void save(Pelamar pelamar) {
        pelamarRepository.save(pelamar);
    }

    public Pelamar getPelamarById(Integer id) {
        return pelamarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pengalaman Id:" + id));
    }

    public Pelamar updatePelamar(int id, Pelamar pengalaman) {
        Pelamar p = pelamarRepository.findById(id).orElse(null);

        if (p == null) return null;

        pelamarRepository.save(p);

        return p;
    }

    public Pelamar deletePelamar(int id) {
        Pelamar p = pelamarRepository.findById(id).orElse(null);

        if (p == null) return null;

        pelamarRepository.delete(p);

        return p;
    }

    public List<LamaranPelamar> getPelamarByIdLowongan(int idLowongan, int statusLamaranAwal, int statusLamaranAkhir) {
        return lamaranPelamarRepository.findPelamarsByIdLowongan(idLowongan, statusLamaranAwal, statusLamaranAkhir);
    }

    public LamaranPelamar getPelamarByIdLamaran(int idLamaran) {
        return lamaranPelamarRepository.getLamaranPelamarById(idLamaran);
    }
}
