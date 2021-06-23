package com.rps.adagawe.service;

import com.rps.adagawe.model.Pendidikan;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.model.Sertifikat;
import com.rps.adagawe.repository.SertifikatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SertifikatService {

    @Autowired
    SertifikatRepository sertifikatRepository;

    public List<Sertifikat> getAll() {
        return (List<Sertifikat>) sertifikatRepository.findAll();
    }

    public void save(Sertifikat sertifikat) {
        sertifikat.setStatus(1);
        sertifikatRepository.save(sertifikat);
    }

    public Sertifikat getSertifikatById(Integer id) {
        return sertifikatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Sertifikat Id:" + id));
    }

    public Sertifikat updateSertifikat(int id, Sertifikat sertifikat) {
        Sertifikat p = sertifikatRepository.findById(id).orElse(null);
        assert p != null;

        sertifikat.setId(id);
        sertifikat.setPelamar(p.getPelamar());

        sertifikatRepository.save(sertifikat);

        return sertifikat;
    }

    public Sertifikat deleteSertifikat(int id) {
        Sertifikat s = sertifikatRepository.findById(id).orElse(null);
        s.setStatus(0);

        sertifikatRepository.save(s);

        return s;
    }

    public List<Sertifikat> getSertifikatByIdUser(int idUser) {
        return (List<Sertifikat>) sertifikatRepository.findSertifikatByIdUser(idUser);
    }
}
