package com.api.library.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {

	@Id
	private Long id;

	private String name;
	
	@Column(columnDefinition="text")
	private String description;

	@DateTimeFormat
	private Calendar birthday;

	@DateTimeFormat
	private Calendar createdAt;

	@DateTimeFormat
	private Calendar updatedAt;

	@DateTimeFormat
	private Calendar deletedAt;

}
