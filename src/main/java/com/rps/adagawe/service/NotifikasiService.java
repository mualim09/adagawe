package com.rps.adagawe.service;

import com.rps.adagawe.model.Notifikasi;
import com.rps.adagawe.repository.NotifikasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifikasiService {

    @Autowired
    NotifikasiRepository notifikasiRepository;

    public void save(Notifikasi notifikasi) {
        notifikasiRepository.save(notifikasi);
    }
}
