package com.rps.adagawe.config;

import com.rps.adagawe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created on September, 2019
 *
 * @author kamer
 */
@Configuration
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserService userService;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/daftar/**",
						"/",
						"/lowongan/**",
						"/main/**",
						"/masuk/**",
						"/css/**",
						"/js/**",
						"/assets/**",
						"/uploads/**",
						"/img/**", "/font-awesome/**")
				.permitAll()
				.antMatchers("/admin/**").hasAuthority("Admin")
				.antMatchers("/perusahaan/**").hasAuthority("Perusahaan")
				.antMatchers("/pelamar/**").hasAuthority("Pelamar")
				.anyRequest()
				.authenticated()
				.and()
				.logout()
				.logoutUrl("/keluar")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
				.formLogin()
				.successHandler(successHandler)
				.loginPage("/masuk")
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
				.passwordEncoder(bCryptPasswordEncoder);
	}

}
