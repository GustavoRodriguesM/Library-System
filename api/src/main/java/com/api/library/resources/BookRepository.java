package com.api.library.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.library.models.Book;

@RepositoryRestResource(path = "books", collectionResourceRel = "content")
public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findAllByTitleContaining(String title);

	List<Book> findByDeletedAt(Calendar deletedAt);
	
}
