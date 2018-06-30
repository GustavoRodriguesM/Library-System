package br.com.web.libraryJsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.web.libraryJsp.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByTitle(String title);
	
}
