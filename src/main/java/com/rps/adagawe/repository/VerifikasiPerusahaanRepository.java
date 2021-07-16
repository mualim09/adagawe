package com.rps.adagawe.repository;

import com.rps.adagawe.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerifikasiPerusahaanRepository extends CrudRepository<VerifikasiPerusahaan, Integer> {

    @Query(nativeQuery = true, value = "SELECT TOP 1 * from VerifikasiPerusahaan a where a.id_perusahaan = :idPerusahaan order by a.id desc ")
    VerifikasiPerusahaan findLastIdPerusahaan(int idPerusahaan);

    @Query("from VerifikasiPerusahaan a order by a.id desc")
    List<VerifikasiPerusahaan> getVerifikasiPerusahaanDesc();

    @Query(nativeQuery = true, value = "SELECT * from VerifikasiPerusahaan a where a.id_perusahaan = :idPerusahaan")
    List<VerifikasiPerusahaan> findIdPerusahaan(int idPerusahaan);

    List<VerifikasiPerusahaan> findAllByOrderByHasilAsc();

}
