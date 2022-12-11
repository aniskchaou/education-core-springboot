package com.dev.delta.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * userDetailsService
	 * 
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * configure : configuration of http security
	 * 
	 * @param http
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable().authorizeRequests().antMatchers("/amenities/**").hasAnyAuthority("ADMIN")
				.antMatchers("/changelang/**", "/addcheckinuser", "/photos/**", "/login", "/", "/about", "/contact",
						"/blog", "/addmessage", "/scss/**", "/resources/**", "/css/**", "/fonts/**", "/img/**",
						"/assets/**")
				.permitAll()
				.antMatchers("/pay/success", "/pay/success", "/pay/**", "/addcheckinregistration/**",
						"/summarybooking/**", "/paymentbooking/**", "/detailbooking/**", "/bookingroom/**",
						"/validationbooking/**", "/room", "/register", "/resources/**", "/css/**", "/fonts/**",
						"/img/**", "/js/**", "/dist/**", "/plugins/**")
				.permitAll().antMatchers("/adduser").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/dashboard").permitAll().and().logout()
				.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
   */
	}

	/**
	 * passwordEncoder : encode the password
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * authenticationProvider
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
}