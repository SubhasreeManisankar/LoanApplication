package com.demo.entity;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "applicant_details")
@EntityListeners(AuditingEntityListener.class)

@NamedQueries({@NamedQuery (name = "ApplicantEntity.findAllOrderByNameDescending" , query = "select a from ApplicantEntity a ORDER BY a.name DESC")})
@NamedQuery(name = "ApplicantEntity.findByState", query = "select a from ApplicantEntity a where a.state= :state")
public class ApplicantEntity {
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "applicant")
	private List <LoanEntity> loan;
	
	public List<LoanEntity> getLoan() {
		return loan;
	}


	public void setLoan(List<LoanEntity> loan) {
		this.loan = loan;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, name = "applicant_name")
	private String name;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(unique = true,name = "contact_number")
	@NotNull
	private long contactNumber;
	
	@Column(unique = true,name = "email_ID")
	@NotBlank
	private String email;
	
	@Column(name = "state_name")
	private String state;
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)	
	private Date updatedAt;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "ApplicantEntity [id=" + id + ", name=" + name + ", dob=" + dob + ", contactNumber=" + contactNumber
				+ ", email=" + email + ", state=" + state + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}


	

	
	}
	
	
	
	




