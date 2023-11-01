package com.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class LoanDTO implements Serializable {
	
	private Long loanId;
	private Date date;
	private Long term;
	private double amount;
	private String type;
	private Date createdAt;
	private Date updatedAt;
	
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getTerm() {
		return term;
	}
	public void setTerm(Long term) {
		this.term = term;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return "LoanDTO [loanId=" + loanId + ", date=" + date + ", term=" + term + ", amount=" + amount + ", type="
				+ type + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
}
