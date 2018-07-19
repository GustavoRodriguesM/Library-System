package com.api.library.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.models.Book;
import com.api.library.resources.BookRepository;
import com.api.library.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void save(Book book) {
		book.setCreatedAt(Calendar.getInstance());
		book.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public void update(Book book) {
		book.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public Book findById(Long id) {
		return this.bookRepository.getOne(id);
	}

	@Override
	public List<Book> findByTitle(String title) {
		return this.bookRepository.findAllByTitleContaining(title);
	}

	@Override
	public List<Book> findAll() {
		return this.bookRepository.findByDeletedAt(null);
	}

	@Override
	public List<Book> findAllWithTrashed() {
		return this.bookRepository.findAll();
	}

	@Override
	public void disable(Book book) {
		book.setDeletedAt(Calendar.getInstance());
		this.update(book);
	}

	@Override
	public void enable(Book book) {
		book.setDeletedAt(null);
		this.update(book);
	}

	@Override
	public boolean reserve(Book book) {
		if (book.getUnits() < 1)
			return false;

		book.setUnits(book.getUnits() - 1);
		this.update(book);

		return true;
	}

}
