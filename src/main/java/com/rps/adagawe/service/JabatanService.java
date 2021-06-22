package com.rps.adagawe.service;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.repository.JabatanRepository;
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

    public void save(Jabatan jabatan) {
        jabatan.setRowStatus(1);
        jabatanRepository.save(jabatan);
    }

    public Jabatan getJabatanById(Integer id) {
        return jabatanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid jabatan Id:" + id));
    }

    public Jabatan updateJabatan(int id, Jabatan jabatan) {
        Jabatan p = jabatanRepository.findById(id).orElse(null);
        assert p != null;

        jabatan.setId(id);
        jabatan.setRowStatus(1);

        jabatanRepository.save(jabatan);

        return jabatan;
    }

    public Jabatan deleteJabatan(int id, Jabatan jabatan) {
        Jabatan p = jabatanRepository.findById(id).orElse(null);

        assert p != null;

        jabatan.setId(id);
        jabatan.setNamaJabatan(p.getNamaJabatan());
        jabatan.setDeskripsi(p.getDeskripsi());
        jabatan.setRowStatus(0);
        jabatanRepository.save(jabatan);

        return jabatan;
    }

    public List<Jabatan> findJabatanByRowStatus() {

        return (List<Jabatan>) jabatanRepository.findJabatanByRowStatus();
    }
}
