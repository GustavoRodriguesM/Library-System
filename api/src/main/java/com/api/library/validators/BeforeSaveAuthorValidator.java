package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.api.library.models.Author;
import com.api.library.services.AuthorService;

@Component("beforeSaveAuthorValidator")
public class BeforeSaveAuthorValidator implements Validator {
	
	@Autowired
	private AuthorService authorService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Author.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Author author = (Author) target;
		
		authorService.update(author);
		
	}

}
