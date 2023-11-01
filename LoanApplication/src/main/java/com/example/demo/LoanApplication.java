package com.example.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.ApplicantEntity;
import com.demo.exception.ApplicantNotFoundException;
import com.demo.service.ApplicantService;

@SpringBootApplication
@ComponentScan("com.demo")
@EntityScan(basePackages = { "com.demo.entity" })
@EnableJpaAuditing
@EnableJpaRepositories("com.demo.dao")

public class LoanApplication {

	static Logger log = Logger.getLogger(LoanApplication.class.getName());

	public static void main(String[] args) throws ApplicantNotFoundException {
		ApplicationContext ctx = SpringApplication.run(LoanApplication.class, args);
		log.info("Application Started");

		// Task 1
		// Insert Parent entity record
		/*
		 * ApplicantService service = ctx.getBean(ApplicantService.class);
		 * ApplicantEntity applicantobj = new ApplicantEntity();
		 */
		 /*applicantobj.setName("Jimin");
		 * applicantobj.setDob(Date.valueOf("2001-11-8"));
		 * applicantobj.setContactNumber(9546741509l);
		 * applicantobj.setEmail("jimin@gmail.com"); applicantobj.setState("Meghalaya");
		 * 
		 * service.insertApplicant(applicantobj);
		 */

		// Task 2
		// Insert Child entity record
		/*
		 * LoanService service = ctx.getBean(LoanService.class);
		 * 
		 * LoanEntity loanobj = new LoanEntity();
		 * 
		 * 
		 * loanobj.setDate(Date.valueOf("2023-7-15"));
		 * loanobj.setType("Educational Loan"); loanobj.setAmount(200000);
		 * loanobj.setTerm(1l);
		 * 
		 * ApplicantEntity a = new ApplicantEntity(); a.setId(1);
		 * 
		 * loanobj.setApplicant(a);
		 * 
		 * service.insertLoan(loanobj);
		 */

		// Task 3
		// Association of Parent and Child entity

		/*
		 * ApplicantService Aservice = ctx.getBean(ApplicantService.class);
		 * 
		 * ApplicantEntity applicantobj = new ApplicantEntity();
		 * 
		 * applicantobj.setName("Subha");
		 * applicantobj.setDob(Date.valueOf("2003-12-15"));
		 * applicantobj.setContactNumber(9885413064l);
		 * applicantobj.setEmail("subha@gmail.com"); applicantobj.setState("Chennai");
		 * 
		 * LoanService Lservice = ctx.getBean(LoanService.class);
		 * 
		 * LoanEntity loanobj1 = new LoanEntity();
		 * 
		 * loanobj1.setDate(Date.valueOf("2023-7-12")); loanobj1.setType("Car Loan");
		 * loanobj1.setAmount(400000); loanobj1.setTerm(1l);
		 * 
		 * LoanEntity loanobj2 = new LoanEntity();
		 * 
		 * loanobj2.setDate(Date.valueOf("2023-7-12")); loanobj2.setType("Home Loan");
		 * loanobj2.setAmount(2000000); loanobj2.setTerm(5l);
		 * 
		 * 
		 * loanobj1.setApplicant(applicantobj); loanobj2.setApplicant(applicantobj);
		 * 
		 * List <LoanEntity> a = new ArrayList <LoanEntity>(); a.add(loanobj1);
		 * a.add(loanobj2);
		 * 
		 * applicantobj.setLoan(a);
		 * 
		 * Aservice.insertApplicant(applicantobj);
		 */

		// Find by id

		ApplicantService service = ctx.getBean(ApplicantService.class);

		ApplicantEntity applicantobj = new ApplicantEntity();

		/*	System.out.println(service.findApplicant(2l));	
		 * LoanService service = ctx.getBean(LoanService.class);
		 * 
		 * LoanEntity loanobj = new LoanEntity();
		 * 
		 * System.out.println(service.findLoan(4));
		 */

		// Find All
		/*
		 * ApplicantService service = ctx.getBean(ApplicantService.class);
		 * 
		 * ApplicantEntity applicantobj = new ApplicantEntity();
		  System.out.println(service.findAllApplicant());*/
		 

		/*
		 * LoanService service = ctx.getBean(LoanService.class);
		 * 
		 * LoanEntity loanobj = new LoanEntity();
		 * 
		 * System.out.println(service.findAllLoan());
		 */

		// Join process (Eager)

		/*
		 * ApplicantService service = ctx.getBean(ApplicantService.class);
		 * 
		 * ApplicantEntity applicantobj = service.findApplicant(2);
		 * System.out.println("*******Printing---Applicant*******");
		 * System.out.println(applicantobj);
		 * 
		 * List <LoanEntity> loanobj = applicantobj.getLoan();
		 * System.out.println("*******Printing----Loan*********");
		 * 
		 * for(LoanEntity LE : loanobj) { System.out.println("Loan amount: " +
		 * LE.getAmount() + " Loan Type: " + LE.getType()); //System.out.println(LE); }
		 */

		// Transaction

		/*
		 * ApplicantService Aservice = ctx.getBean(ApplicantService.class);
		 * 
		 * ApplicantEntity applicantobj = new ApplicantEntity();
		 * 
		 * applicantobj.setName("Kook"); applicantobj.setDob(Date.valueOf("2004-10-5"));
		 * applicantobj.setContactNumber(9154892054l);
		 * applicantobj.setEmail("kook@gmail.com"); applicantobj.setState("Assam");
		 * 
		 * LoanEntity loanobj = new LoanEntity();
		 * 
		 * loanobj.setDate(Date.valueOf("2023-7-17")); loanobj.setType("Jewel Loan");
		 * loanobj.setAmount(700000); loanobj.setTerm(1);
		 * 
		 * ApplicantEntity applicant = new ApplicantEntity(); applicant.setId(3); s
		 * loanobj.setApplicant(applicant);
		 * 
		 * Aservice.transactionDemo(applicantobj, loanobj);
		 */

		// Custom Queries (Parent Entity)
		// ApplicantService service = ctx.getBean(ApplicantService.class);

		/*
		 * List <ApplicantEntity> list = service.findApplicantById(1l);
		 * System.out.println("Applicant > ID 1: " + list);
		 */

		/*
		 * List <ApplicantEntity> list1 = service.findApplicantByName("i");
		 * System.out.println("Applicant name with 'i': " + list1);
		 */

		// System.out.println("Maximum Applicant ID: " + service.findMaxId());

		/*
		 * List <ApplicantEntityCustomized> list2 =
		 * service.findApplicantByNameCustomized("Jimin"); for(ApplicantEntityCustomized
		 * c : list2) { System.out.println("Customized Details: " + c.getEmailId() +
		 * ", " + c.getContactNumber() ); }
		 */

		// Named Queries (Parent Entity)
		// System.out.println("Applicant details Order by name desc: " +
		// service.findAllOrderByNameDescending());
		// System.out.println("Applicant details by state: " +
		// service.findByState("chennai"));

		// Joins (Parent Entity)
		// Inner Join
		/*
		 * List <ApplicantEntity> list3 = service.findApplicantWithLoans();
		 * System.out.println("Applicant with Loans Inner Join: " + list3);
		 */

		// Left Outer Join
		/*
		 * List <ApplicantEntity> list4 = service.findApplicantWithLoansLeft();
		 * System.out.println("Applicant with Loans Left Outer Join: " + list4);
		 */

		// Customized join
		/*
		 * List <ApplicantLoanCustomized> list5 =
		 * service.findApplicantWithLoansCustomized(); for(ApplicantLoanCustomized alc :
		 * list5) { System.out.println("Applicant with Loans Customized join: " +
		 * alc.getName() + ", " + alc.getState() + ", " + alc.getContactNumber()); }
		 */

	}

}
