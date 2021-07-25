package com.rps.adagawe.repository;

import com.rps.adagawe.model.Lamaran;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.Pelamar;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LamaranRepository extends CrudRepository<Lamaran, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "EXEC eliminatePelamarByPendidikan @IdLowongan = :idLowongan")
    void eliminatePelamarsByPendidikan(int idLowongan);

    Lamaran getLamaranById(int idLowongan);

    @Query("from Lamaran where pelamar.id = :id")
    List<Lamaran> getLamaranByIdPelamar(int id);

    @Query("select COUNT(DISTINCT lowongan.perusahaan.userLogin.nama) from Lamaran where pelamar.id = :id")
    int getCountLamaranByPelamar(int id);
}
