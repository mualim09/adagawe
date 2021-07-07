package com.rps.adagawe.repository;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.JenisPegawai;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.VerifikasiPerusahaan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerifikasiPerusahaanRepository extends CrudRepository<VerifikasiPerusahaan, Integer> {

        @Query(nativeQuery = true, value = "SELECT TOP 1 a.id from Perusahaan a ORDER BY a.id DESC")
        int findLastId();

}
