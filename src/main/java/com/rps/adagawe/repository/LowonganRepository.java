package com.rps.adagawe.repository;

import com.rps.adagawe.model.Lowongan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowonganRepository extends CrudRepository<Lowongan, Integer> {

}
