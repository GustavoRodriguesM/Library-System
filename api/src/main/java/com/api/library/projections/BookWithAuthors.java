package com.api.library.projections;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.api.library.models.Author;
import com.api.library.models.Book;

@Projection(name = "bookWithAuthors", types =  Book.class ) 
public interface BookWithAuthors {

	Long getId();
	
	String getTitle();
	
	String getDescription();
	
	String getCover();
	
	Integer getUnits();
	
	String getIsbn();
	
	List<Author> getAuthors();
}
