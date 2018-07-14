package com.api.library.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(columnDefinition="text")
	private String description;

	@DateTimeFormat
	private Calendar birthday;

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
