package com.dev.delta.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationController {

	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "auth/login";
	}
}
