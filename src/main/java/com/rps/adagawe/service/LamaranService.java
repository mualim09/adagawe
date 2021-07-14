package com.rps.adagawe.service;

import com.rps.adagawe.model.Admin;
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


    public List<Pelamar> getPelamarByIdLowongan(int idLowongan) {
        return null;
    }
}
