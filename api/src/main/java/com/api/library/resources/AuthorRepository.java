package com.api.library.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.library.models.Author;

@RepositoryRestResource(path = "authors", collectionResourceRel = "content")
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByName(String name);

	List<Author> findAllByDeletedAt(Calendar deletedAt);

}
