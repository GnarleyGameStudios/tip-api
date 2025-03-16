package com.poketeam.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/tip")
	public String index() {
		return "You have touched the tip!";
	}

}
