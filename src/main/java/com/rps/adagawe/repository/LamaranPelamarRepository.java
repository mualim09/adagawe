package com.rps.adagawe.repository;

import com.rps.adagawe.model.LamaranPelamar;
import com.rps.adagawe.model.Pelamar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LamaranPelamarRepository extends CrudRepository<LamaranPelamar, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM view_LamaranPelamar WHERE id_lowongan = :idLowongan " +
            "AND (status_lamaran >= :statusLamaranAwal AND status_lamaran <= :statusLamaranAkhir)")
    List<LamaranPelamar> findPelamarsByIdLowongan(int idLowongan, int statusLamaranAwal, int statusLamaranAkhir);

    @Query(nativeQuery = true, value = "SELECT * FROM view_LamaranPelamar WHERE id_lamaran = :idLamaran")
    LamaranPelamar getLamaranPelamarById(int idLamaran);

    @Query(nativeQuery = true, value = "SELECT * FROM view_LamaranPelamar WHERE id_lowongan = :idLowongan AND status_lamaran = 0")
    List<LamaranPelamar> getLamaranPelamarByIdLowongan(int idLowongan);
}
