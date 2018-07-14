package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.api.library.models.User;
import com.api.library.services.UserService;

@Component("beforeSaveUserValidator")
public class BeforeSaveUserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		this.userService.update(user);

		if (user.getPassword() != null && user.getPasswordConfirmation() != null) {
			if (user.getPassword().length() < 7)
				errors.rejectValue("password", "min.length");
			else if (!user.getPasswordConfirmation().equals(user.getPassword()))
				errors.rejectValue("passwordConfirmation", "not.equals.password");
		}
	}
}
