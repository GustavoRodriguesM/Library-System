package com.api.library.services.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.models.Loan;
import com.api.library.resources.LoanRepository;
import com.api.library.services.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void save(Loan loan) {
		loan.setCreatedAt(Calendar.getInstance());
		loan.setUpdatedAt(Calendar.getInstance());
		addSevenDays(loan);
		loan.setActivated(true);
	}

	@Override
	public void update(Loan loan) {
		loan.setUpdatedAt(Calendar.getInstance());
		this.loanRepository.save(loan);
	}

	@Override
	public Loan findById(Long id) {
		return this.loanRepository.getOne(id);
	}

	@Override
	public List<Loan> findAll() {
		return this.loanRepository.findAllByDeletedAt(null);
	}

	@Override
	public List<Loan> findAllWithTrashed() {
		return this.loanRepository.findAll();
	}

	@Override
	public void disable(Loan loan) {
		loan.setDeletedAt(Calendar.getInstance());
		this.update(loan);
	}

	@Override
	public void enable(Loan loan) {
		loan.setDeletedAt(null);
		this.update(loan);
	}
	
	private void addSevenDays(Loan loan) {
		Calendar devolution = new GregorianCalendar();
		devolution.setTime(Calendar.getInstance().getTime());
		devolution.add(Calendar.DATE, 7);
		loan.setDevolutionIn(devolution);
	}

}
