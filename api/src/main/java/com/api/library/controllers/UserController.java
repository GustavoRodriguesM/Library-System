package com.api.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.models.User;
import com.api.library.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users/exists/{email}")
	public Boolean checkEmailTaken(@PathVariable String email) {
		return this.userService.checkEmailTaken(email);
	}

	@PostMapping("/users/{id}/disable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User disable(@PathVariable Long id) {
		User user = this.userService.findById(id);
		this.userService.disable(user);
		return user;
	}

	@PostMapping("/users/{id}/enable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User enable(@PathVariable Long id) {
		User user = this.userService.findById(id);
		this.userService.enable(user);
		return user;
	}

}
