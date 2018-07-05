package br.com.web.libraryJsp.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.web.libraryJsp.models.Author;

@RepositoryRestResource(path = "authors", collectionResourceRel = "authors")
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByName(String name);

}
