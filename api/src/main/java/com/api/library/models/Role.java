package com.api.library.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -9182242770709653671L;

	@Id
	private String name;

	public Role(String role) {
		this.name = role;
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
