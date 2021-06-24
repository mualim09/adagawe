package com.rps.adagawe.repository;

import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.JenisPegawai;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on June, 2021
 * @author RPS
 */

@Repository
public interface JenisPegawaiRepository extends CrudRepository<JenisPegawai, Integer> {

    @Query("from JenisPegawai a WHERE a.rowStatus = 1")
    List<JenisPegawai> findJenisPegawaiByRowStatus();
}
