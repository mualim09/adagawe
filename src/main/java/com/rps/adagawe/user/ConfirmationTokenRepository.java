package com.rps.adagawe.user;

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
interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

	@Query("from ConfirmationToken a WHERE a.confirmationToken = :token")
	ConfirmationToken findConfirmationTokenByConfirmationToken(String token);

}
