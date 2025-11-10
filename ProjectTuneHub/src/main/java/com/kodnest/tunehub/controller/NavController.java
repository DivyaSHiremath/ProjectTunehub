package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/Login")
	public String Login() {
		return "Login";
		}
	@GetMapping("/Registeration")
	public String Registeration() {
		return "Registeration";
	
	}
	
	@GetMapping("/Newsong")
	public String Newsong() {
		return "Newsong";
	
	}
	
}

