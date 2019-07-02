package com.bank.customer.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Customer {
	@NotNull(message = "customer id cannot be null")
	private Integer customerId;
	private String customerName;
	private String customerRole;
	@NotEmpty(message = "phone number cannot be null and empty")
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
