package com.rps.adagawe.repository;

import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Repository
public interface UserRepository extends CrudRepository<UserLogin, Long> {

	Optional<UserLogin> findByEmail(String email);
}
