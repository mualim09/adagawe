package com.rps.adagawe.service;

import com.rps.adagawe.model.Notifikasi;
import com.rps.adagawe.repository.NotifikasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifikasiService {

    @Autowired
    NotifikasiRepository notifikasiRepository;

    public void save(Notifikasi notifikasi) {
        notifikasiRepository.save(notifikasi);
    }

    public List<Notifikasi> getAll() {
        return notifikasiRepository.findAllByOrderByCreatedDateDesc();
    }

    public List<Notifikasi> getNotifikasiByPelamar(int idPelamar) {
        return notifikasiRepository.getNotifikasiByIdPelamar(idPelamar);
    }

    public Notifikasi getNotifikasiByIdLamaranAndTahap(int idLamaran, String tahap) {
        return notifikasiRepository.getNotifikasiByIdLamaranAndTahap(idLamaran, tahap);
    }

    public List<Notifikasi> getNotifikasiByIdLamaran(int idLamaran) {
        return notifikasiRepository.findAllByIdLamaran(idLamaran);
    }

    public Notifikasi getNotifikasiById(int idNotifikasi) {
        return notifikasiRepository.findById(idNotifikasi).orElse(null);
    }

    public void konfirmasi(int idNotifikasi, int konfirmasi) {
        Notifikasi notifikasi = getNotifikasiById(idNotifikasi);

        if (notifikasi != null) {
            notifikasi.setTerkonfirmasi(konfirmasi);
            notifikasiRepository.save(notifikasi);
        }
    }

}
