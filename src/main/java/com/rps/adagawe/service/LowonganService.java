package com.rps.adagawe.service;

import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.repository.LowonganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LowonganService {
    @Autowired
    LowonganRepository lowonganRepository;

    public List<Lowongan> getAll() {
        return (List<Lowongan>) lowonganRepository.findAll();
    }

    public Lowongan getLowonganById(Integer id) {
        return lowonganRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Lowongan Id:" + id));
    }
}
