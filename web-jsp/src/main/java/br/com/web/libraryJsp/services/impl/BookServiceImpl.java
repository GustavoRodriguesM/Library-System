package br.com.web.libraryJsp.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web.libraryJsp.models.Book;
import br.com.web.libraryJsp.repositories.BookRepository;
import br.com.web.libraryJsp.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book save(Book book) {
		book.setCreatedAt(Calendar.getInstance());
		book.setUpdatedAt(Calendar.getInstance());

		return this.bookRepository.save(book);
	}

	@Override
	public Book update(Book book) {
		book.setUpdatedAt(Calendar.getInstance());

		return this.bookRepository.save(book);
	}

	@Override
	public Book findById(Long id) {
		return this.bookRepository.getOne(id);
	}

	@Override
	public Book findByTitle(String title) {
		return this.bookRepository.findByTitle(title);
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

}
