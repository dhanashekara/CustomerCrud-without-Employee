package com.bank.customer.service;

import org.springframework.stereotype.Service;

import com.bank.customer.constants.Constants;
import com.bank.customer.entity.Customer;

@Service
public class CustomerService {

	public String addCustomer(Customer customer) {
		if ((Constants.customerDetailsNew.get(customer.getCustomerId())) != null) {
			Constants.customerDetailsNew.put(customer.getCustomerId(), customer);
			return "customer added successfully";
		} else {
			return "customer already exist!";
		}
	}

	public Object getCustomer(Integer customerId) {
		if (Constants.customerDetailsNew.get(customerId) != null)
			return Constants.customerDetailsNew.get(customerId);
		else
			return "Customer Doesn't exist";
	}

	public Object deleteCustomer(Integer customerId) {

		if (Constants.customerDetailsNew.get(customerId) != null) {
			Constants.customerDetailsNew.remove(customerId);
			return "deleted successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

	public Object updateCustomer(Integer customerId, String customerName) {
		if (Constants.customerDetailsNew.get(customerId) != null) {
			Customer cust = Constants.customerDetailsNew.get(customerId);
			cust.setCustomerName(customerName);
			Constants.customerDetailsNew.put(customerId, cust);
			return "updated successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

}
