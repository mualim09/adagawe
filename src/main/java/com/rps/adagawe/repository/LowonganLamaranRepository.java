package com.rps.adagawe.repository;

import com.rps.adagawe.model.LowonganLamaran;
import com.rps.adagawe.model.PelamarLamaran;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LowonganLamaranRepository extends CrudRepository<LowonganLamaran, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM view_LowonganLamaran WHERE id_perusahaan = :idPerusahaan")
    List<LowonganLamaran> getLowonganByIdPerusahaan(int idPerusahaan);
}
