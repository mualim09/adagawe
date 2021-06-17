package com.rps.adagawe.service;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.repository.JabatanRepository;
import com.rps.adagawe.repository.PelamarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JabatanService {
    @Autowired
    JabatanRepository jabatanRepository;

    public List<Jabatan> getAll() {
        return (List<Jabatan>) jabatanRepository.findAll();
    }
}
