package com.rps.adagawe.repository;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on June, 2021
 * @author RPS
 */

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    @Query("from UserLogin a WHERE a.email = :email")
    UserLogin getAdminByUserLogin(String email);

}
