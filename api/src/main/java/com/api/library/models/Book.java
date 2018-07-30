package com.api.library.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "books")
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Column(columnDefinition="text")
	private String description;

	private String cover;
	
	private Integer units;
	
	private String isbn;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Author> authors;

	@ManyToMany
	private List<Category> categories;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar createdAt;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar updatedAt;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar deletedAt;

}
