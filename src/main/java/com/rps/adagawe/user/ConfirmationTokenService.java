package com.rps.adagawe.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Service
@AllArgsConstructor
class ConfirmationTokenService {

	private final ConfirmationTokenRepository confirmationTokenRepository;

	void saveConfirmationToken(ConfirmationToken confirmationToken) {

		confirmationTokenRepository.save(confirmationToken);
	}

	void deleteConfirmationToken(Long id) {

		confirmationTokenRepository.deleteById(id);
	}


	ConfirmationToken findConfirmationTokenByToken(String token) {
		ConfirmationToken c = confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
		System.out.println(c);
		return c;
	}

}
