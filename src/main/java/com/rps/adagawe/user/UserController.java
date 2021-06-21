package com.rps.adagawe.user;

import com.rps.adagawe.model.UserLogin;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@GetMapping("/sign-in")
	public String signIn(Model model) {
		return "main/login";
	}

	@GetMapping("/sign-up")
	public String signUpPage(Model model, UserLogin user) {
		model.addAttribute("user", new UserLogin());
		return "main/register";
	}

	@PostMapping("/sign-up")
	public String signUp(UserLogin user) {

		userService.signUpUser(user);

		return "redirect:/sign-in";
	}

	@GetMapping("/sign-up/confirm")
	public String confirmMail(@RequestParam("token") String token) {

		ConfirmationToken confirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

		if (confirmationToken != null) userService.confirmUser(confirmationToken);

		return "redirect:/sign-in";
	}

}
