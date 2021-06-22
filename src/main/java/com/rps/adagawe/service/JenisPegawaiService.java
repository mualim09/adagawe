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

    public void save(JenisPegawai jenisPegawai) {
        jenisPegawai.setRowStatus(1);
        jenisPegawaiRepository.save(jenisPegawai);
    }

    public JenisPegawai getJenisPegawaiById(Integer id) {
        return jenisPegawaiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid jabatan Id:" + id));
    }

    public JenisPegawai updateJenisPegawai(int id, JenisPegawai jenisPegawai) {
        JenisPegawai p = jenisPegawaiRepository.findById(id).orElse(null);
        assert p != null;

        jenisPegawai.setId(id);
        jenisPegawai.setRowStatus(1);

        jenisPegawaiRepository.save(jenisPegawai);

        return jenisPegawai;
    }

    public JenisPegawai deleteJenisPegawai(int id, JenisPegawai jenisPegawai) {
        JenisPegawai p = jenisPegawaiRepository.findById(id).orElse(null);

        assert p != null;

        jenisPegawai.setId(id);
        jenisPegawai.setNamajenisPegawai(p.getNamajenisPegawai());
        jenisPegawai.setRowStatus(0);
        jenisPegawaiRepository.save(jenisPegawai);

        return jenisPegawai;
    }

    public List<JenisPegawai> findJenisPegawaiByRowStatus() {

        return (List<JenisPegawai>) jenisPegawaiRepository.findJenisPegawaiByRowStatus();
    }
}
