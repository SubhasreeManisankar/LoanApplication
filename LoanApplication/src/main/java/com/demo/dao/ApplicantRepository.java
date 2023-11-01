package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.ApplicantEntity;
import com.demo.entity.LoanEntity;

@Repository
public interface ApplicantRepository extends JpaRepository <ApplicantEntity,Long> {
//Fetching all columns
	@Query(value = "select a from ApplicantEntity a where a.id> :id1")
	List <ApplicantEntity> findApplicantById(@Param("id1") Long id);
	
	@Query("select a from ApplicantEntity a where a.name LIKE %:name1%")
	List <ApplicantEntity> findApplicantByName(@Param("name1") String name);
	
	@Query("select MAX(a.id) FROM ApplicantEntity a")
	 Long findMaxId();
	
//Fetching only few columns
	@Query("select a.email as emailId, a.contactNumber as contactNumber from ApplicantEntity a where a.name=:name1")
	List <ApplicantEntityCustomized> findApplicantByNameCustomized(@Param("name1") String name);
	
//Named Query
	List <ApplicantEntity> findAllOrderByNameDescending();
	List <ApplicantEntity> findByState(String state);
	
//Joins
	//Inner Join
	@Query("select a from ApplicantEntity a JOIN a.loan l")
	List <ApplicantEntity> findApplicantWithLoans();
	
	//Left Outer Join
	@Query("select a from ApplicantEntity a Left JOIN a.loan l")
	List <ApplicantEntity> findApplicantWithLoansLeft();
	
	//Customized data by join
	@Query("select a.name as name,a.state as state,a.contactNumber as contactNumber from ApplicantEntity a JOIN a.loan l")
	List<ApplicantLoanCustomized> findApplicantWithLoansCustomized();
	
	
	
	
	
	
	
	
}
