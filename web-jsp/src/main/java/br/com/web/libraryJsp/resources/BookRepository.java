package br.com.web.libraryJsp.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.web.libraryJsp.models.Book;

@RepositoryRestResource(path = "books", collectionResourceRel = "books")
public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByTitle(String title);

	List<Book> findByDeletedAt(Calendar deletedAt);
	
}
