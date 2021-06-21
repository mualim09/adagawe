package com.rps.adagawe.service;

import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.repository.PengalamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengalamanService {
    @Autowired
    PengalamanRepository pengalamanRepository;

    public List<Pengalaman> getAll() {
        return (List<Pengalaman>) pengalamanRepository.findAll();
    }

    public void save(Pengalaman pengalaman) {
        pengalamanRepository.save(pengalaman);
    }

    public Pengalaman getPengalamanById(Integer id) {
        return pengalamanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pengalaman Id:" + id));
    }

    public Pengalaman updatePengalaman(int id, Pengalaman pengalaman) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);
        assert p != null;

        pengalaman.setId(id);
        pengalaman.setPelamar(p.getPelamar());

        pengalamanRepository.save(pengalaman);

        return pengalaman;
    }

    public Pengalaman deletePengalaman(int id) {
        Pengalaman p = pengalamanRepository.findById(id).orElse(null);

        if (p == null) return null;

        pengalamanRepository.delete(p);

        return p;
    }
}
