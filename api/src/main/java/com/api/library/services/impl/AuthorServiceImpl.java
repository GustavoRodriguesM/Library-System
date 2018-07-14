package com.api.library.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.models.Author;
import com.api.library.resources.AuthorRepository;
import com.api.library.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void save(Author author) {
		author.setCreatedAt(Calendar.getInstance());
		author.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public void update(Author author) {
		author.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public Author findById(Long id) {
		return this.authorRepository.getOne(id);
	}

	@Override
	public List<Author> findAll() {
		return this.authorRepository.findAllByDeletedAt(null);
	}

	@Override
	public List<Author> findAllWithTrashed() {
		return this.authorRepository.findAll();
	}

	@Override
	public void disable(Author author) {
		author.setDeletedAt(Calendar.getInstance());
		this.update(author);
	}

	@Override
	public void enable(Author author) {
		author.setDeletedAt(null);
		this.update(author);
	}

}
