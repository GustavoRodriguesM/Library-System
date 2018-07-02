package br.com.web.libraryJsp.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "categories")
public class Category {

	@Id
	private String name;

	@DateTimeFormat
	private Calendar createdAt;

	@DateTimeFormat
	private Calendar updatedAt;

	@DateTimeFormat
	private Calendar deletedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
