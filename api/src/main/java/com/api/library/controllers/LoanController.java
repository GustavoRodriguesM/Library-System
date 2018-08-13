package com.api.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.models.Loan;
import com.api.library.services.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping(value = "/loans/{id}/remand", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String remand(@PathVariable Long id) {
		Loan loan = this.loanService.findById(id);
		this.loanService.remand(loan);
		return "{\"success\": \"true\"}";
	}

}
