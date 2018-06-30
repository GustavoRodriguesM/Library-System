package br.com.web.libraryJsp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "categories")
public class Category {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
