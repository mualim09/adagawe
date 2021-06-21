package com.rps.adagawe.repository;

import com.rps.adagawe.model.ConfirmationToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

	@Query("from ConfirmationToken a WHERE a.confirmationToken = :token")
	ConfirmationToken findConfirmationTokenByConfirmationToken(String token);
}
