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
//    List<Lamaran> findLamaransByIdLowongan(int idLowongan);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Lamaran SET status_lamaran = 1 WHERE id IN (" +
            "SELECT id_lamaran FROM view_LamaranPelamar WHERE id_lowongan = :idLowongan AND tingkatan_jenjang < jenjang_minimal AND status_lamaran = 0)")
    void eliminatePelamarsByPendidikan(int idLowongan);
}
