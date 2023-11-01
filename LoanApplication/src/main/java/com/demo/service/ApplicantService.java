package com.demo.service;

import java.util.List;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bo.ApplicantBO;
import com.demo.bo.LoanBO;
import com.demo.dao.ApplicantEntityCustomized;
import com.demo.dao.ApplicantLoanCustomized;
import com.demo.entity.ApplicantEntity;
import com.demo.entity.LoanEntity;
import com.demo.exception.ApplicantInvalidException;
import com.demo.exception.ApplicantNotFoundException;
import com.example.demo.LoanApplication;


@Component
public class ApplicantService {
	
	@Autowired
	ApplicantBO bo;
	
	@Autowired
	LoanBO bo1;
	
	static Logger log = Logger.getLogger(LoanApplication.class.getName());
	
	//Insert
	public ApplicantEntity insertApplicant(ApplicantEntity addApplicant)throws ApplicantInvalidException
	{
		log.info("Insert method triggered");
		try 
		{
			log.info("Record inserted successfully");
			return bo.insertApplicant(addApplicant); 
		}
		catch (ApplicantInvalidException e)
		{
			log.error("Error while inserting record",e); 
			throw new ApplicantInvalidException("Applicant name Invalid");
		}
	}
		
	//Update
	public ApplicantEntity updateApplicant(ApplicantEntity updateApplicant)throws ApplicantInvalidException
	{
		log.info("Update method triggered");
		try 
		{
			log.info("Record updated successfully");
			return bo.updateApplicant(updateApplicant);
		}
		catch (ApplicantInvalidException e)
		{
			log.error("Error while updating record",e); 
			throw new ApplicantInvalidException("Applicant email Invalid");
		}
	}
		
	//Find All
	public List <ApplicantEntity> findAllApplicant() throws ApplicantNotFoundException
	{
		log.info("Find All method triggered");
		try
		{
			log.info("Records Fetched successfully");
			return bo.findAllApplicant();
		}
		catch (ApplicantNotFoundException e) 
		{
			log.error("Error while fetching records",e);
            throw new ApplicantNotFoundException("No Applicants Found");
        }
		
	}
	//Find by Id
	public ApplicantEntity findApplicant(Long id1) throws ApplicantNotFoundException
	{
		log.info("Find by ID method triggered");
		try 
		{
			log.info("Record Fetched successfully");
		return bo.findApplicant(id1);
		}
		catch (ApplicantNotFoundException e) 
		{
			log.error("Error while fetching record",e);
            throw new ApplicantNotFoundException("Applicant" + id1 + "Not Found");
        }
	}
	
	//Transaction
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transactionDemo(ApplicantEntity a, LoanEntity l) throws ApplicantInvalidException
	{
		System.out.println("Applicant add----Before----");
		bo.insertApplicant(a);
		System.out.println("Applicant add----After----");
		
		System.out.println("Loan add----Before----");
		bo1.insertLoan(l);
		System.out.println("Loan add----After----");
	
	}
	
	//Custom queries
	public List <ApplicantEntity> findApplicantById(Long id1)
	{
		return bo.findApplicantById(id1);
	}
	

	public List <ApplicantEntity> findApplicantByName(String name1)
	{
		return bo.findApplicantByName(name1);
	}
	
	public Long findMaxId()
	{
		return bo.findMaxId();
	}
	
	public List <ApplicantEntityCustomized> findApplicantByNameCustomized(String name1)
	{
		return bo.findApplicantByNameCustomized(name1);
	}
	
	//Named Query
	public List <ApplicantEntity> findAllOrderByNameDescending()
	{
		return bo.findAllOrderByNameDescending();
	
	}
	
	public List <ApplicantEntity> findByState(String state)
	{
		return bo.findByState(state);
	}

	
	//Inner Join
	public List <ApplicantEntity> findApplicantWithLoans()
	{
		return bo.findApplicantWithLoans();
	}
	
	//Left Outer Join
	public List <ApplicantEntity> findApplicantWithLoansLeft()
	{
		return bo.findApplicantWithLoansLeft();
	}
	
	//Customized join
	public List <ApplicantLoanCustomized> findApplicantWithLoansCustomized()
	{
		return bo.findApplicantWithLoansCustomized();
	}
}
