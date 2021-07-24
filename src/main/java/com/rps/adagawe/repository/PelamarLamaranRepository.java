package com.rps.adagawe.repository;

import com.rps.adagawe.model.PelamarLamaran;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PelamarLamaranRepository extends CrudRepository<PelamarLamaran, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM view_LamaranPelamar lp " +
            "JOIN Lamaran l ON l.id = lp.id_lamaran WHERE lp.id_pelamar = :idPelamar " +
            "ORDER BY l.tanggal_melamar DESC")
    List<PelamarLamaran> getPelamarLamaranByIdPelamar(int idPelamar);
}
