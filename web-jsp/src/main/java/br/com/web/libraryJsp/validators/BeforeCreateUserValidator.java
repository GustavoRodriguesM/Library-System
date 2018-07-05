package br.com.web.libraryJsp.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.web.libraryJsp.models.User;
import br.com.web.libraryJsp.services.UserService;

@Service("beforeCreateUserValidator")
public class BeforeCreateUserValidator implements Validator {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		
		this.userService.save(user);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");

	}
}
