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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "loans")
@Getter
@Setter
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
	private Calendar createdAt;

}
