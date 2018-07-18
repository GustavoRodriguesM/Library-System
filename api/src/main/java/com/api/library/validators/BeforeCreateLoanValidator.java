package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.api.library.models.Loan;
import com.api.library.services.LoanService;

@Component("beforeCreateLoanValidator")
public class BeforeCreateLoanValidator implements Validator {
	
	@Autowired
	private LoanService loanService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Loan.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Loan loan = (Loan) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "book", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "devolutionIn", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activated", "field.required");

		loanService.save(loan);
	}

}
