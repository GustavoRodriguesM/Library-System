package com.api.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.models.Category;
import com.api.library.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories/{id}/disable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Category disable(@PathVariable Long id) {
		Category category = this.categoryService.findById(id);
		this.categoryService.disable(category);
		return category;
	}
	
	@PostMapping("/categories/{id}/enable")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Category enable(@PathVariable Long id) {
		Category category = this.categoryService.findById(id);
		this.categoryService.enable(category);
		return category;
	}

}
