package com.rps.adagawe.service;

import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.repository.JenisPegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisPegawaiService {
    @Autowired
    JenisPegawaiRepository jenisPegawaiRepository;

    public List<JenisPegawai> getAll() {
        return (List<JenisPegawai>) jenisPegawaiRepository.findAll();
    }
}
