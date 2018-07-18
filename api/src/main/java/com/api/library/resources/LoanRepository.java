package com.api.library.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.library.models.Loan;

@RepositoryRestResource(path = "loans", collectionResourceRel = "loans")
public interface LoanRepository extends JpaRepository<Loan, Long>{

	List<Loan> findAllByDeletedAt(Calendar deletedAt);

}
