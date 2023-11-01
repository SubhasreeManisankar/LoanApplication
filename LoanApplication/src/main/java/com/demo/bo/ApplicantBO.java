package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.ApplicantEntityCustomized;
import com.demo.dao.ApplicantLoanCustomized;
import com.demo.dao.ApplicantRepository;
import com.demo.entity.ApplicantEntity;
import com.demo.exception.ApplicantInvalidException;
import com.demo.exception.ApplicantNotFoundException;

@Component
public class ApplicantBO {
	
	@Autowired
	ApplicantRepository reapplicant;
	//Insert
	public ApplicantEntity insertApplicant(ApplicantEntity addApplicant)throws ApplicantInvalidException
	{
		if (addApplicant.getName()==null|| addApplicant.getName().isEmpty())
		{
			throw new ApplicantInvalidException("Applicant name cannot be empty");
		}
		return reapplicant.save(addApplicant);
	}
	//Update
	public ApplicantEntity updateApplicant(ApplicantEntity updateApplicant)throws ApplicantInvalidException
	{
		if(updateApplicant.getEmail().isEmpty())
		{
			throw new ApplicantInvalidException("Applicant email cannot be empty");
		}
		return reapplicant.save(updateApplicant);
	}
	//Find All
	public List <ApplicantEntity> findAllApplicant()throws ApplicantNotFoundException
	{
		
		 try
		 {
			 return reapplicant.findAll(); 
		 }
		 catch (Exception e)
		 {
			 throw new ApplicantNotFoundException("No applicants found",e);
	     } 
		
	}
	//Find By Id 
	public ApplicantEntity findApplicant(Long id1) throws ApplicantNotFoundException
	{
		Optional <ApplicantEntity> fetch = reapplicant.findById(id1);
		 if (fetch.isPresent())
		 {
			 return fetch.get();
	     }
		 else
		 {
			 throw new ApplicantNotFoundException("Applicant with ID " + id1 + " not found");
		 }
		
	}
	
	//Custom Queries
	public List <ApplicantEntity> findApplicantById(Long id1)
	{
		return reapplicant.findApplicantById(id1);
	}
	
	public List <ApplicantEntity> findApplicantByName(String name1)
	{
		return reapplicant.findApplicantByName(name1);
	}
	
	public Long findMaxId()
	{
		return reapplicant.findMaxId();
	}
	
	public List <ApplicantEntityCustomized> findApplicantByNameCustomized(String name1)
	{
		return reapplicant.findApplicantByNameCustomized(name1);
	}
	
	//Named Query
	public List <ApplicantEntity> findAllOrderByNameDescending()
	{
		return reapplicant.findAllOrderByNameDescending();
		
	}
	
	public List <ApplicantEntity> findByState(String state)
	{
		return reapplicant.findByState(state);
	}

	//Inner Join
	public List <ApplicantEntity> findApplicantWithLoans()
	{
		return reapplicant.findApplicantWithLoans();
	}
	
	//Left Outer Join
	public List <ApplicantEntity> findApplicantWithLoansLeft()
	{
		return reapplicant.findApplicantWithLoansLeft();
	}
	
	// Customized join
	public List <ApplicantLoanCustomized> findApplicantWithLoansCustomized()
	{
		return reapplicant.findApplicantWithLoansCustomized();
	}
}
