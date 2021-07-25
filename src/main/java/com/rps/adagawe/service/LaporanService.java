package com.rps.adagawe.service;

import com.rps.adagawe.model.Bidang;
import com.rps.adagawe.model.LowonganLamaran;
import com.rps.adagawe.model.PelamarLamaran;
import com.rps.adagawe.repository.BidangRepository;
import com.rps.adagawe.repository.LowonganLamaranRepository;
import com.rps.adagawe.repository.PelamarLamaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaporanService {
    @Autowired
    PelamarLamaranRepository pelamarLamaranRepository;

    @Autowired
    LowonganLamaranRepository lowonganLamaranRepository;

    @Autowired
    BidangRepository bidangRepository;

    public List<PelamarLamaran> getLamaranByIdPelamar(int idPelamar) {
        return pelamarLamaranRepository.getPelamarLamaranByIdPelamar(idPelamar);
    }

    public List<LowonganLamaran> getLowonganByIdPerusahaan(int idPerusahaan) {
        return lowonganLamaranRepository.getLowonganByIdPerusahaan(idPerusahaan);
    }

    public List<Bidang> getBidang() {
        return bidangRepository.getAllBidang();
    }
}
