package br.com.web.libraryJsp.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "clients")
public class Client {

	private Long id;

	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
