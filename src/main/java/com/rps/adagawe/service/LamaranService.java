package com.rps.adagawe.service;

import com.rps.adagawe.model.Lamaran;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.repository.LamaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LamaranService {
    @Autowired
    LamaranRepository lamaranRepository;

    public void save(Lamaran lamaran) {
        lamaranRepository.save(lamaran);
    }


    public List<Pelamar> getLamaranByIdLowongan(int idLowongan) {
        return null;
    }

    public void eliminatePelamarByPendidikan(int idLowongan) {
        lamaranRepository.eliminatePelamarsByPendidikan(idLowongan);
    }

    public void eliminatePelamarByNilaiUjikom(int idLowongan, double nilai) {
        lamaranRepository.eliminatePelamarsByNilaiUjikom(idLowongan, nilai);
    }

    public void eliminatePelamarByNilaiWawancara(int idLowongan, double nilai) {
        lamaranRepository.eliminatePelamarsByNilaiWawancara(idLowongan, nilai);
    }

    public Lamaran getLamaranById(int idLamaran) {
        return lamaranRepository.getLamaranById(idLamaran);
    }

    public List<Lamaran> getLamaranByIdPelamar(int id) {
        return lamaranRepository.getLamaranByIdPelamar(id);
    }

    public int getCountLamaranPerusahaanByPelamar(int id) {
        return lamaranRepository.getCountLamaranByPelamar(id);
    }
}
