package com.rps.adagawe.repository;

import com.rps.adagawe.model.Pengalaman;
import com.rps.adagawe.model.Sertifikat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PengalamanRepository extends CrudRepository<Pengalaman, Integer> {

    @Query("from Pengalaman a WHERE a.rowStatus = 1")
    List<Pengalaman> findPengalamanByRowStatus();

    @Query("from Pengalaman a WHERE a.pelamar.id = :idUser and a.rowStatus = 1")
    List<Pengalaman> findPengalamanByIdUser(int idUser);
}
