package com.api.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="/users/exists/{email}")
	public Boolean checkEmailTaken(@PathVariable String email) {
		return this.userService.checkEmailTaken(email);
	}
	
}
