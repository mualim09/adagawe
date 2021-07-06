package com.rps.adagawe.helper;

import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdagaweRepository extends CrudRepository<UserLogin, Integer> {

    @Query("from UserLogin a WHERE a.email = :email")
    UserLogin getUserLoginByEmail(String email);
}