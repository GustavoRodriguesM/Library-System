package br.com.web.libraryJsp.services;

import br.com.web.libraryJsp.models.Book;

public interface BookService extends AbstractService<Book, Long> {

	Book findByTitle(String title);

}
