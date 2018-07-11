package com.api.library.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.api.library.models.User;

@Component("beforeCreateUserValidator")
public class BeforeCreateUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirmation", "field.required");

		User user = (User) target;

		if (user.getPassword() != null && user.getPasswordConfirmation() != null) {
			if (user.getPassword().length() < 7)
				errors.rejectValue("password", "min.length");
			else if (!user.getPasswordConfirmation().equals(user.getPassword()))
				errors.rejectValue("passwordConfirmation", "not.equals.password");
		}
	}
}
