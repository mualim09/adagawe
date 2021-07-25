package com.rps.adagawe.repository;

import com.rps.adagawe.model.Notifikasi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotifikasiRepository extends CrudRepository<Notifikasi, Integer> {
    List<Notifikasi> findAllByOrderByCreatedDateDesc();

    @Query("from Notifikasi n WHERE n.idLamaran = :idLamaran AND n.tahapSelanjutnya = :tahap")
    Notifikasi getNotifikasiByIdLamaranAndTahap(int idLamaran, String tahap);

    @Query("from Notifikasi n WHERE n.idLamaran = :idLamaran")
    List<Notifikasi> findAllByIdLamaran(int idLamaran);

    @Query(nativeQuery = true, value = "SELECT n.* FROM Notifikasi n JOIN Lamaran l ON n.id_lamaran = l.id WHERE l.id_pelamar = :idPelamar")
    List<Notifikasi> getNotifikasiByIdPelamar(int idPelamar);
}
