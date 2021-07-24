package com.rps.adagawe.service;

import com.rps.adagawe.model.PelamarLamaran;
import com.rps.adagawe.repository.PelamarLamaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelamarLamaranService {
    @Autowired
    PelamarLamaranRepository pelamarLamaranRepository;

    public List<PelamarLamaran> getByIdPelamar(int idPelamar) {
        return pelamarLamaranRepository.getPelamarLamaranByIdPelamar(idPelamar);
    }
}
