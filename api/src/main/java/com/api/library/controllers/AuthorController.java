package com.api.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.models.Author;
import com.api.library.services.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/authors/{id}/disable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Author disable(@PathVariable Long id) {
		Author author = this.authorService.findById(id);
		this.authorService.disable(author);
		return author;
	}
	
	@PostMapping("/authors/{id}/enable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Author enable(@PathVariable Long id) {
		Author author = this.authorService.findById(id);
		this.authorService.enable(author);
		return author;
	}
	
}
