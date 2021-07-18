package com.rps.adagawe.service;

import com.rps.adagawe.model.Pesan;
import com.rps.adagawe.repository.PesanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesanService {

    @Autowired
    PesanRepository pesanRepository;

    public List<Pesan> getByPesanUntuk(int id) {
        return pesanRepository.findPesanByPesanUntuk(id);
    }
}