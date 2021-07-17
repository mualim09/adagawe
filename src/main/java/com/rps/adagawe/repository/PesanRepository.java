package com.rps.adagawe.repository;

import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.Pesan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesanRepository extends CrudRepository<Pesan, Integer> {

    @Query("from Pesan where pesanUntuk.id = :id")
    List<Pesan> findPesanByPesanUntuk(int id);
}
