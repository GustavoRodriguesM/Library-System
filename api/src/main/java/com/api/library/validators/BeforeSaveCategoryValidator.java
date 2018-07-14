package com.api.library.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.api.library.models.Category;
import com.api.library.services.CategoryService;

@Component("beforeSaveCategoryValidator")
public class BeforeSaveCategoryValidator implements Validator {

	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		categoryService.update(category);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");

	}

}
