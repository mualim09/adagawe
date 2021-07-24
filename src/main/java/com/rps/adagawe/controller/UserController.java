package com.rps.adagawe.controller;

import com.rps.adagawe.helper.AdagaweConstants;
import com.rps.adagawe.model.ConfirmationToken;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.model.UserRole;
import com.rps.adagawe.service.ConfirmationTokenService;
import com.rps.adagawe.service.PerusahaanService;
import com.rps.adagawe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	private final ConfirmationTokenService confirmationTokenService;

	@Autowired
	private PerusahaanService perusahaanService;

	@GetMapping("/register")
	public String getRegister(Model model, HttpServletRequest request) {
		model.addAttribute("user", new UserLogin());

		return "/main/register";
	}

	@PostMapping("/register")
	public String postRegister(Model model, UserLogin user) {
		user.setUserRole(UserRole.Perusahaan);
		user.setFotoProfil(AdagaweConstants.FOTO_PERUSAHAAN_DEFAULT);
		userService.signUpUser(user);

		return "redirect:/masuk";
	}

	@GetMapping("/masuk")
	public String signIn(Model model) {
		model.addAttribute("user", new UserLogin());

		return "main/login";
	}

	@GetMapping("/template")
	public String sigsfdf(Model model) {
		return "perusahaan";
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
