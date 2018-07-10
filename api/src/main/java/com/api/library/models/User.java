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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	@JsonProperty(access = Access.READ_ONLY)
	private String token;

	private String passwordUncoded;
	private String passwordUncodedConfirmation;

	@JsonIgnore
	private String passwordDigest;

	@DateTimeFormat
	private Calendar birthday;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar createdAt;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar updatedAt;

	@DateTimeFormat
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar deletedAt;

	public User(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getRoles();
		this.passwordDigest = user.getPasswordDigest();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday.getTimeInMillis()
				+ ", roles=" + roles + "]";
	}

	@JsonIgnore
	public boolean isDeleted() {
		return deletedAt != null;
	}

}
