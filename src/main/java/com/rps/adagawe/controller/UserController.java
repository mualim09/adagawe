package com.rps.adagawe.controller;

import com.rps.adagawe.model.ConfirmationToken;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.service.ConfirmationTokenService;
import com.rps.adagawe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	private final ConfirmationTokenService confirmationTokenService;

	@GetMapping("/masuk")
	public String signIn(Model model) {
		return "main/login";
	}

	@GetMapping("/daftar")
	public String signUpPage(Model model, UserLogin user) {
		model.addAttribute("user", new UserLogin());
		return "main/register";
	}

	@PostMapping("/daftar")
	public String signUp(UserLogin user) {

		userService.signUpUser(user);

		return "redirect:/masuk";
	}

	@GetMapping("/daftar/confirm")
	public String confirmMail(@RequestParam("token") String token) {

		ConfirmationToken confirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

		if (confirmationToken != null) userService.confirmUser(confirmationToken);

		return "redirect:/masuk";
	}

}
