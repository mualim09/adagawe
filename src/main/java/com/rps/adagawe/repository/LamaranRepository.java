package com.rps.adagawe.repository;

import com.rps.adagawe.model.Lamaran;
import com.rps.adagawe.model.Lowongan;
import com.rps.adagawe.model.Pelamar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LamaranRepository extends CrudRepository<Lamaran, Integer> {
//    List<Lamaran> findLamaransByIdLowongan(int idLowongan);

}
