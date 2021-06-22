package com.rps.adagawe.repository;

import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.model.Sertifikat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SertifikatRepository extends CrudRepository<Sertifikat, Integer> {

    @Query("from Sertifikat a WHERE a.pelamar.id = :idUser")
    List<Sertifikat> findSertifikatByIdUser(int idUser);
}
