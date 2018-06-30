package br.com.web.libraryJsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.web.libraryJsp.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	Author findByName(String name);

}
