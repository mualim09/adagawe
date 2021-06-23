package com.rps.adagawe.service;

import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.model.Pendidikan;
import com.rps.adagawe.model.Pendidikan;
import com.rps.adagawe.repository.PendidikanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendidikanService {

    @Autowired
    PendidikanRepository pendidikanRepository;

    public List<Pendidikan> getAll() {
        return (List<Pendidikan>) pendidikanRepository.findAll();
    }

    public void save(Pendidikan pendidikan) {
        pendidikan.setRowStatus(1);
        pendidikanRepository.save(pendidikan);
    }

    public Pendidikan getPendidikanById(Integer id) {
        return pendidikanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pendidikan Id:" + id));
    }

    public Pendidikan updatePendidikan(int id, Pendidikan pendidikan) {
        Pendidikan p = pendidikanRepository.findById(id).orElse(null);
        assert p != null;

        pendidikan.setId(id);
        pendidikan.setPelamar(p.getPelamar());
        pendidikan.setRowStatus(1);

        pendidikanRepository.save(pendidikan);

        return pendidikan;
    }

    public Pendidikan deletePendidikan(int id, Pendidikan pendidikan) {
        Pendidikan p = pendidikanRepository.findById(id).orElse(null);

        assert p != null;

        pendidikan.setId(id);
        pendidikan.setPelamar(p.getPelamar());
        pendidikan.setJenjang(p.getJenjang());
        pendidikan.setNamaJurusan(p.getNamaJurusan());
        pendidikan.setNamaUniversitas(p.getNamaUniversitas());
        pendidikan.setTahunMulai(p.getTahunMulai());
        pendidikan.setTahunSelesai(p.getTahunSelesai());
        pendidikan.setRowStatus(0);
        pendidikanRepository.save(pendidikan);

        return pendidikan;
    }

    public List<Pendidikan> findPendidikanByRowStatus() {
        return (List<Pendidikan>) pendidikanRepository.findPendidikanByRowStatus();
    }

    public List<Pendidikan> getPendidikanByIdUser(int idUser) {
        return (List<Pendidikan>) pendidikanRepository.findPendidikanByIdUser(idUser);
    }
}
