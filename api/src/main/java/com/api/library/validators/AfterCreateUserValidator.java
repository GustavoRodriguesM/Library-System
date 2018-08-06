package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.api.library.models.Client;
import com.api.library.models.User;
import com.api.library.resources.ClientRepository;
import com.api.library.services.UserService;

@Component("afterCreateUserValidator")
public class AfterCreateUserValidator implements Validator {

	@Autowired
	private ClientRepository clientService;

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (this.userService.hasRole(user, "ROLE_CLIENT")) {
			Client client = new Client();
			client.setUser(user);
			this.clientService.save(client);
		}
	}

}
