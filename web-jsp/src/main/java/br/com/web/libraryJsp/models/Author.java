package br.com.web.libraryJsp.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "authors")
public class Author {

	@Id
	private Long id;

	private String name;
	private String description;

	@DateTimeFormat
	private Calendar birthday;

	@DateTimeFormat
	private Calendar createdAt;

	@DateTimeFormat
	private Calendar updatedAt;

	@DateTimeFormat
	private Calendar deletedAt;

	// GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Calendar getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Calendar deletedAt) {
		this.deletedAt = deletedAt;
	}

}
