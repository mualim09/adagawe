package com.rps.adagawe.repository;

import com.rps.adagawe.model.Daerah;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaerahRepository extends CrudRepository<Daerah, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM view_LaporanDaerah")
    List<Daerah> getAllDaerah();
}
