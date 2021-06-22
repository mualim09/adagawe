package com.rps.adagawe.repository;

import com.rps.adagawe.model.Pendidikan;
import com.rps.adagawe.model.Pengalaman;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendidikanRepository extends CrudRepository<Pendidikan, Integer>  {

    @Query("from Pendidikan a WHERE a.rowStatus = 1")
    List<Pendidikan> findPendidikanByRowStatus();
}
