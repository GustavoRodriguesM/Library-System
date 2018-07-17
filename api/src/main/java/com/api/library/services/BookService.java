package com.api.library.services;

import java.util.List;

import com.api.library.models.Book;

public interface BookService extends DefaultService<Book, Long> {

	List<Book> findByTitle(String title);

}
