package com.rps.adagawe.repository;

import com.rps.adagawe.model.Lowongan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LowonganRepository extends CrudRepository<Lowongan, Integer> {

    @Query("from Lowongan a where a.perusahaan.id = :idPerusahaan order by a.id desc")
    List<Lowongan> getLowonganByIdPerusahaan(int idPerusahaan);

    @Query("from Lowongan a where a.status = 1")
    List<Lowongan> getLowonganByStatus();
}