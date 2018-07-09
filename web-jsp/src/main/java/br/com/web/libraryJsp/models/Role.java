package br.com.web.libraryJsp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "roles")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -9182242770709653671L;
	
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

	@Override
	public String getAuthority() {
		return this.name;
	}
}
