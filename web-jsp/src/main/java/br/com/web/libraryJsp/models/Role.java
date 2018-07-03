package br.com.web.libraryJsp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "roles")
public class Role {

	@Id
	private String name;

	public Role() {
	}

	public Role(String role) {
		this.name = role;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
