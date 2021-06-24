package com.rps.adagawe.repository;

import com.rps.adagawe.model.ConfirmationToken;
import com.rps.adagawe.model.Jabatan;
import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on June, 2021
 * @author RPS
 */

@Repository
public interface JabatanRepository extends CrudRepository<Jabatan, Integer> {

    @Query("from Jabatan a WHERE a.rowStatus = 1")
    List<Jabatan> findJabatanByRowStatus();
}
