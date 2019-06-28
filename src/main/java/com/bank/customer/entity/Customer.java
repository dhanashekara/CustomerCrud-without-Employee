package com.bank.customer.entity;

public class Customer {
	
	private Integer customerId;
	private String customerName;
	private String customerRole;
	private String phonerNumber;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerRole() {
		return customerRole;
	}
	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}
	public String getPhonerNumber() {
		return phonerNumber;
	}
	public void setPhonerNumber(String phonerNumber) {
		this.phonerNumber = phonerNumber;
	}
}
