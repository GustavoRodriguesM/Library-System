package br.com.web.libraryJsp.models;

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

@Entity(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	// GETTERS AND SETTERS

	public User() {
	}

	public User(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.roles = user.getRoles();
		this.passwordDigest = user.getPasswordDigest();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPasswordDigest() {
		return passwordDigest;
	}

	public void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public String getPasswordUncoded() {
		return passwordUncoded;
	}

	public void setPasswordUncoded(String passwordUncoded) {
		this.passwordUncoded = passwordUncoded;
	}

	public String getPasswordUncodedConfirmation() {
		return passwordUncodedConfirmation;
	}

	public void setPasswordUncodedConfirmation(String passwordUncodedConfirmation) {
		this.passwordUncodedConfirmation = passwordUncodedConfirmation;
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
