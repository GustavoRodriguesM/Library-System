package com.api.library.services;

import com.api.library.models.Book;

public interface BookService extends DefaultService<Book, Long> {

	Book findByTitle(String title);

}
