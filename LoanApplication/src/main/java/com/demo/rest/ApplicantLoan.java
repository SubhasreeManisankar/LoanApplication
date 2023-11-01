package com.demo.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.UserRepository;
import com.demo.dto.ApplicantDTO;
import com.demo.dto.LoginRequest;
import com.demo.entity.ApplicantEntity;
import com.demo.entity.User;
import com.demo.exception.ApplicantInvalidException;
import com.demo.exception.ApplicantNotFoundException;
import com.demo.response.ResponseObject;
import com.demo.service.ApplicantService;
import com.demo.service.LoanService;
@CrossOrigin 
@RestController
public class ApplicantLoan {
	
	@Autowired
	ApplicantService service1;
	
	@Autowired
	LoanService service2;
	
	@Autowired
    private UserRepository userRepository;
	
	//Sample
	@RequestMapping("/sayHello")
	public String sayHello()
	{
		return "Say Hello";
	}
	
	//Crud Methods
	
	//Insert(parent)
	@RequestMapping(value = "/createApplicant", method = RequestMethod.POST)
	public ResponseObject insertApplicant(@RequestBody ApplicantDTO msg)
	{
		ResponseObject responseObject = new ResponseObject();
		
		try
		{
		System.out.println("Name: " + msg.getName());
		System.out.println("DOB: " + msg.getDob());
		System.out.println("ContactNumber: " + msg.getContactNumber());
		System.out.println("EmailID: " + msg.getEmail());
		System.out.println("State: " + msg.getState());
		
		ApplicantEntity a = new ApplicantEntity();
		a.setName(msg.getName());
		a.setDob(msg.getDob());
		a.setContactNumber(msg.getContactNumber());
		a.setEmail(msg.getEmail());
		a.setState(msg.getState());
		
		ApplicantEntity a1 = service1.insertApplicant(a);
		msg.setId(a1.getId());
		msg.setCreatedAt(a1.getCreatedAt());
		msg.setUpdatedAt(a1.getUpdatedAt());
		
		responseObject.setSuccessMessage("Applicant inserted successfully");
		 responseObject.setApplicantList(Collections.singletonList(msg));
		 
		return responseObject;
	}
		catch (ApplicantInvalidException e) 
		{
            responseObject.setFailureMessage("Invalid insertion----Applicant name cannot be empty");
        }
		catch (Exception e)
		{
	        responseObject.setFailureMessage("Error occurred while inserting");
	    }
		 
		return responseObject;
	}
		
	
	//FindById(parent)
	@RequestMapping(value = "/findApplicantById", method = RequestMethod.GET)
	public ResponseObject findApplicant(@RequestParam Long id)
	{
		ResponseObject responseObject = new ResponseObject();
		
		try 
		{
			System.out.println("ID: " + id);
			ApplicantEntity a = service1.findApplicant(new Long(id));
		
		ApplicantDTO dto = new ApplicantDTO();
		dto.setId(a.getId());
		dto.setName(a.getName());
		dto.setDob(a.getDob());
		dto.setContactNumber(a.getContactNumber());
		dto.setEmail(a.getEmail());
		dto.setState(a.getState());
		dto.setCreatedAt(a.getCreatedAt());
		dto.setUpdatedAt(a.getUpdatedAt());
		
		responseObject.setSuccessMessage("Applicant found successfully");
		 responseObject.setApplicantList(Collections.singletonList(dto));
		 
		 return responseObject;
		}
		catch (ApplicantNotFoundException e) 
		{
            responseObject.setFailureMessage("Applicant with given ID not found");
        }
		catch (Exception e)
		{
	        responseObject.setFailureMessage("Error occurred while fetching");
	    }
		 
		return responseObject;
		
	}
	
	//Find All(parent)
	@RequestMapping(value = "/findAllApplicants", method = RequestMethod.GET)
	public ResponseObject findAllApplicant()
	{
		 ResponseObject responseObject = new ResponseObject();
		 
		 try 
		 {
		 List<ApplicantEntity> applicants = service1.findAllApplicant();
		 List<ApplicantDTO> dtos = new ArrayList<>();
		 
		 for (ApplicantEntity a : applicants)
		 {
			 ApplicantDTO dto = new ApplicantDTO();
			 dto.setId(a.getId());
			 dto.setName(a.getName());
			 dto.setDob(a.getDob());
			 dto.setContactNumber(a.getContactNumber());
			 dto.setEmail(a.getEmail());
			 dto.setState(a.getState());
			 dto.setCreatedAt(a.getCreatedAt());
			 dto.setUpdatedAt(a.getUpdatedAt());
			 
			 dtos.add(dto);
		 }
		 		responseObject.setSuccessMessage("Applicants fetched successfully");
	            responseObject.setApplicantList(dtos);
	            return responseObject;
		 }
		 catch (ApplicantNotFoundException e) 
			{
	            responseObject.setFailureMessage("No Applicants Fetched ");
	        }
		 catch (Exception e) 
		 {
		        responseObject.setFailureMessage("Error occurred while fetching");
	     }
		 
		 return responseObject;
	}
	
	//Update(parent)
	@RequestMapping(value = "/updateApplicant/{aid}", method = RequestMethod.POST)
	public ResponseObject updateApplicant(@PathVariable("aid")long id, @RequestBody ApplicantDTO msg)
	{
		ResponseObject responseObject = new ResponseObject();
		
		try
		{
		System.out.println("Name: " + msg.getName());
		System.out.println("DOB: " + msg.getDob());
		System.out.println("ContactNumber: " + msg.getContactNumber());
		System.out.println("EmailID: " + msg.getEmail());
		System.out.println("State: " + msg.getState());
		
		ApplicantEntity a = service1.findApplicant(id);
		a.setName(msg.getName());
		a.setDob(msg.getDob());
		a.setContactNumber(msg.getContactNumber());
		a.setEmail(msg.getEmail());
		a.setState(msg.getState());
		
		ApplicantEntity a1 = service1.updateApplicant(a);
		ApplicantDTO ad = new ApplicantDTO();
		ad.setId(a1.getId());
		ad.setName(a1.getName());
		ad.setDob(a1.getDob());
		ad.setContactNumber(a1.getContactNumber());
		ad.setEmail(a1.getEmail());
		ad.setState(a1.getState());
		ad.setCreatedAt(a1.getCreatedAt());
		ad.setUpdatedAt(a1.getUpdatedAt());
		
		responseObject.setSuccessMessage("Applicant updated successfully");
		 responseObject.setApplicantList(Collections.singletonList(ad));
		 
		return responseObject;
	}
		catch (ApplicantInvalidException e) 
		{
            responseObject.setFailureMessage("Invalid updation----Applicant email cannot be empty");
        }
		catch (Exception e)
		{
	        responseObject.setFailureMessage("Error occurred while updating");
	    }
		 
		return responseObject;
	}
		
	
	//Insert(Child)
	/*@RequestMapping(value = "/createLoan", method = RequestMethod.POST)
	public LoanEntity insertLoan(@RequestBody LoanEntity msg)
	{
		System.out.println("Applied Date: " + msg.getDate());
		System.out.println("Loan Term: " + msg.getTerm());
		System.out.println("Loan Amount: " + msg.getAmount());
		System.out.println("Loan Type: " + msg.getType());
		System.out.println("Applicant ID: " + msg.getApplicant().getId());
		
		ApplicantEntity applicantResponse = service1.findApplicant(msg.getApplicant().getId());
		System.out.println("Applicant Response----> " + applicantResponse);
		
		LoanEntity l = new LoanEntity();
		l.setDate(msg.getDate());
		l.setTerm(msg.getTerm());
		l.setAmount(msg.getAmount());
		l.setType(msg.getType());
		msg.setApplicant(applicantResponse);
		
		LoanEntity response = service2.insertLoan(msg);
		System.out.println("Added successfully :) ");
		return response;
	}
	
	//FindById(Child)
	@RequestMapping(value = "/findLoanById", method = RequestMethod.GET)
	public LoanEntity findLoan(@RequestParam Long id)
	{
		System.out.println("Loan ID: " + id);
		LoanEntity l = service2.findLoan(id);
		l.getLoanId();
		l.getDate();
		l.getTerm();
		l.getAmount();
		l.getType();
		l.getCreatedAt();
		l.getUpdatedAt();
		
		System.out.println("Loan Fetched Successfully :) ");
		return l;
	}
	
	//Find All(Child)
	@RequestMapping(value = "/findAllLoans", method = RequestMethod.GET)
	public List<LoanEntity> findAllLoan()
	{
		 List<LoanEntity> findAll = service2.findAllLoan();
		 return findAll;
	}
	
	//Update(Child)
	@RequestMapping(value = "/updateLoan/{lid}", method = RequestMethod.POST)
	public LoanEntity updateLoan(@PathVariable("lid")long id, @RequestBody LoanEntity msg)
	{
		//System.out.println("Applied Date: " + msg.getDate());
		System.out.println("Loan Term: " + msg.getTerm());
		System.out.println("Loan Amount: " + msg.getAmount());
		//System.out.println("Loan Type: " + msg.getType());
		//System.out.println("Applicant ID: " + msg.getApplicant().getId());
		
		LoanEntity l = service2.findLoan(id);
		//l.setDate(msg.getDate());
		l.setTerm(msg.getTerm());
		l.setAmount(msg.getAmount());
		//l.setType(msg.getType());
		//l.setApplicant(msg.getApplicant());
		
		LoanEntity l1 = service2.updateLoan(l);
		System.out.println("Loan updated successfully:) ");
		return l1;
	}*/
	
	// Queries Methods
	
	//Greater than ID 
	@RequestMapping(value = "/greaterThanId", method = RequestMethod.GET)
	public List<ApplicantEntity> findApplicantById(@RequestParam Long id)
	{
		 List<ApplicantEntity> list = service1.findApplicantById(id);
		 return list;
		 
	}
	
	//FindByName
	/*@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public List<ApplicantEntity> findApplicantByName(@RequestParam String name) 
	{
	    List<ApplicantEntity> list = service1.findApplicantByName(name);
	    return list;
	}
	
	//FindByNameCustomized
	@RequestMapping(value = "/findByNameCustomized", method = RequestMethod.GET)
	public List<ApplicantEntityCustomized> findApplicantByNameCustomized(@RequestParam String name) 
	{
	    List<ApplicantEntityCustomized> list = service1.findApplicantByNameCustomized(name);
	    return list;
	}*/
	
	//FindMaxID
	@RequestMapping(value = "/findMaxId", method = RequestMethod.GET)
	public Long findMaxId() {
	    Long maxId = service1.findMaxId();
	    return maxId;
	}

	//FindAllOrderByNameDesc
	/*@RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
	public List<ApplicantEntity> findAllOrderByNameDescending() 
	{
	    List<ApplicantEntity> list = service1.findAllOrderByNameDescending();
	    return list;
	}*/
	
	//FindByState
	@RequestMapping(value = "/findByState", method = RequestMethod.GET)
	public List<ApplicantEntity> findByState(@RequestParam String state) 
	{
        List<ApplicantEntity> list = service1.findByState(state);
        return list;
    }

	//Inner Join
	/* @RequestMapping(value = "/applicantsWithLoans", method = RequestMethod.GET)
	    public List<ApplicantEntity> findApplicantWithLoans()
	 {
	        List<ApplicantEntity> list = service1.findApplicantWithLoans();
	        return list;
	 }
	 
	 //Left Outer Join
	 @RequestMapping(value = "/applicantsWithLoansLeft", method = RequestMethod.GET)
	    public List<ApplicantEntity> findApplicantWithLoansLeft() 
	 {
	        List<ApplicantEntity> list = service1.findApplicantWithLoansLeft();
	        return list;
	 }
	 
	//Customized join
	 @RequestMapping(value = "/applicantsWithLoansCustomized", method = RequestMethod.GET)
	    public  List <ApplicantLoanCustomized> findApplicantWithLoansCustomized() 
	 {
		 List <ApplicantLoanCustomized> list = service1.findApplicantWithLoansCustomized();
	        return list;
	 }*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            response.put("success", true);
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
}	
	}
}

