package com.poketeam.api.controller;

import com.poketeam.api.controller.ro.UserRO;
import com.poketeam.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@PostMapping("/users")
	public String createUser(@RequestBody UserRO user) {
		return "user controller endpoint";
	}
}
