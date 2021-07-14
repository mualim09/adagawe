package com.rps.adagawe.repository;

import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on June, 2021
 * @author RPS
 */

@Repository
public interface PelamarRepository  extends CrudRepository<Pelamar, Integer> {

    @Query("from Pelamar a WHERE a.rowStatus = 1")
    List<Pelamar> findPelamarByRowStatus();

    @Query(nativeQuery = true, value = "SELECT * FROM lamaran_pelamar WHERE id_lowongan = :idLowongan " +
            "AND (status_lamaran >= :statusLamaranAwal AND status_lamaran <= :statusLamaranAkhir)")
    List<Pelamar> findPelamarsByIdLowongan(int idLowongan, int statusLamaranAwal, int statusLamaranAkhir);
}
