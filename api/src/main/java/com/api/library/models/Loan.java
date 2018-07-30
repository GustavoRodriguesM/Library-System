package com.api.library.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "loans")
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Book book;

	@ManyToOne
	private Client client;

	@DateTimeFormat
	private Calendar devolutionIn;

	private boolean activated;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar updatedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(access = Access.READ_ONLY)
	private Calendar deletedAt;

}
