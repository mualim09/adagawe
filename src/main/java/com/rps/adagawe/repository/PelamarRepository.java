package com.rps.adagawe.repository;

import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PelamarRepository  extends CrudRepository<Pelamar, Integer> {

    @Query("from Pelamar a WHERE a.rowStatus = 1")
    List<Pelamar> findPelamarByRowStatus();

    @Query("from Pelamar a WHERE a.userLogin.id = :userId")
    Pelamar getPelamarByUserLogin(int userId);

    @Query("from UserLogin a WHERE a.email = :email")
    UserLogin getIdUserLoginByEmail(String email);


}
