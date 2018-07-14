package com.api.library.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.models.Category;
import com.api.library.resources.CategoryRepository;
import com.api.library.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		category.setCreatedAt(Calendar.getInstance());
		category.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public void update(Category category) {
		category.setUpdatedAt(Calendar.getInstance());
	}
	
	@Override
	public Category findById(Long id) {
		return this.categoryRepository.getOne(id);
	}

	@Override
	public List<Category> findAll() {
		return this.categoryRepository.findAllByDeletedAt(null);
	}

	@Override
	public List<Category> findAllWithTrashed() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void disable(Category category) {
		category.setDeletedAt(Calendar.getInstance());
		this.update(category);
	}

	@Override
	public void enable(Category category) {
		category.setDeletedAt(null);
		this.update(category);
	}

}
