package com.rps.adagawe.service;

import com.rps.adagawe.model.ConfirmationToken;
import com.rps.adagawe.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {

	private final ConfirmationTokenRepository confirmationTokenRepository;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenRepository.save(confirmationToken);
	}

	public void deleteConfirmationToken(Long id) {
		confirmationTokenRepository.deleteById(id);
	}


	public ConfirmationToken findConfirmationTokenByToken(String token) {
		ConfirmationToken c = confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
		System.out.println(c);
		return c;
	}

}
