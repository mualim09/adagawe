package com.rps.adagawe.repository;

import com.rps.adagawe.model.Percakapan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PercakapanRepository extends CrudRepository<Percakapan, Integer> {

    @Query("from Percakapan where pesan.id = :id")
    List<Percakapan> findPercakapanByPesan(int id);
}
