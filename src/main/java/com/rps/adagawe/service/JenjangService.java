package com.rps.adagawe.service;

import com.rps.adagawe.model.Jenjang;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.repository.JenjangRepository;
import com.rps.adagawe.repository.PelamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenjangService {
    @Autowired
    JenjangRepository jenjangRepository;

    public List<Jenjang> getAll() {
        return (List<Jenjang>) jenjangRepository.findAll();
    }

    public void save(Jenjang jenjang) {
        jenjangRepository.save(jenjang);
    }

    public Jenjang getJenjangById(Integer id) {
        return jenjangRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid jenjang Id:" + id));
    }
}
