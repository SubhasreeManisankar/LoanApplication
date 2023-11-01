package com.demo.response;

import java.util.List;

import com.demo.dto.ApplicantDTO;

public class ResponseObject 
{ 
	 private String successMessage;
	 private String failureMessage;
	 private List<ApplicantDTO> applicantList;
	
	 //Getters Setters
	 public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public List<ApplicantDTO> getApplicantList() {
		return applicantList;
	}
	public void setApplicantList(List<ApplicantDTO> applicantList) {
		this.applicantList = applicantList;
	}

	
	
	
	
	
}
