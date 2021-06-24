package com.rps.adagawe.repository;

import com.rps.adagawe.model.ConfirmationToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on June, 2021
 * @author RPS
 */

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

	@Query("from ConfirmationToken a WHERE a.confirmationToken = :token")
	ConfirmationToken findConfirmationTokenByConfirmationToken(String token);
}
