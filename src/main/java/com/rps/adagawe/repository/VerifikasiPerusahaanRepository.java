package com.rps.adagawe.repository;

import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.VerifikasiPerusahaan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerifikasiPerusahaanRepository extends CrudRepository<VerifikasiPerusahaan, Integer> {

    @Query("from VerifikasiPerusahaan a order by a.id desc")
    List<VerifikasiPerusahaan> getVerifikasiPerusahaanDesc();
}
