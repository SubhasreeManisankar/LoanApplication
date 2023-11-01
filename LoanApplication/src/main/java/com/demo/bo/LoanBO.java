package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.LoanRepository;
import com.demo.entity.LoanEntity;

@Component
public class LoanBO {
	
	@Autowired
	LoanRepository reloan;
	
	public LoanEntity insertLoan(LoanEntity addLoan)
	{
		return reloan.save(addLoan);
	}
	
	public LoanEntity updateLoan(LoanEntity updateLoan)
	{
		return reloan.save(updateLoan);
	}
	
	public List <LoanEntity> findAllLoan()
	{
		return reloan.findAll();
	}
	
	public LoanEntity findLoan(Long id)
	{
		Optional <LoanEntity> fetch = reloan.findById(id);
		return fetch.get();
	}

}
