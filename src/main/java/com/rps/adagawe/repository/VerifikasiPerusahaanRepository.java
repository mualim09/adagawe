package com.rps.adagawe.repository;

import com.rps.adagawe.model.VerifikasiPerusahaan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifikasiPerusahaanRepository extends CrudRepository<VerifikasiPerusahaan, Integer> {

}
