package com.rps.adagawe.user;

import com.rps.adagawe.model.UserLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Repository
interface UserRepository extends CrudRepository<UserLogin, Long> {

	Optional<UserLogin> findByEmail(String email);
}
