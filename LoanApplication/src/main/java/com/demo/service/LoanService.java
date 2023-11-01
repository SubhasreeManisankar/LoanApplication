package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.LoanBO;
import com.demo.entity.LoanEntity;

@Component
public class LoanService {
	
	@Autowired
	LoanBO bo;
	//Insert
	public LoanEntity insertLoan(LoanEntity addLoan)
	{
		return bo.insertLoan(addLoan);
	}
	//Update
	public LoanEntity updateLoan(LoanEntity updateLoan)
	{
		return bo.updateLoan(updateLoan);
	}
	//Find All
	public List <LoanEntity> findAllLoan()
	{
		return bo.findAllLoan();
	}
	//FindById
	public LoanEntity findLoan(Long id)
	{
		return bo.findLoan(id);
	}
	

	
	
}