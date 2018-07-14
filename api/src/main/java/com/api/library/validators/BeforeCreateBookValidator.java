package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.api.library.models.Book;
import com.api.library.services.BookService;

@Component("beforeCreateBookValidator")
public class BeforeCreateBookValidator implements Validator {

	@Autowired
	private BookService bookService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Book book = (Book) target;
		
		bookService.save(book);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cover", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "units", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "field.required");

		if (book.getCategories() == null)
			errors.rejectValue("categories", "field.required");

		if (book.getAuthors() == null)
			errors.rejectValue("authors", "field.required");
	}

}
