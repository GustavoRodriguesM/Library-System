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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordUncoded", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordUncodedConfirmation", "field.required");

		User user = (User) target;

		if (user.getPasswordUncoded() != null && user.getPasswordUncodedConfirmation() != null) {
			if (user.getPasswordUncoded().length() < 7)
				errors.rejectValue("passwordUncoded", "min.length");
			else if (!user.getPasswordUncodedConfirmation().equals(user.getPasswordUncoded()))
				errors.rejectValue("passwordUncodedConfirmation", "not.equals.password");
		}
	}
}
