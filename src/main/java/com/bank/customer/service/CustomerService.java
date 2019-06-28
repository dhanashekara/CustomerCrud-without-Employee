package com.bank.customer.service;

import org.springframework.stereotype.Service;

import com.bank.customer.entity.Customer;
import com.bank.customer.model.Model;

@Service
public class CustomerService {

	public String addCustomer(Customer customer) {
		if (Model.customerDetailsNew.get(customer.getCustomerId()) == null) {
			Model.customerDetailsNew.put(customer.getCustomerId(), customer);
			return "customer added successfully";
		} else {
			return "customer already exists";
		}
	}

	public Object getCustomer(Integer customerId) {
		if (Model.customerDetailsNew.get(customerId) != null)
			return Model.customerDetailsNew.get(customerId);
		else
			return "Customer Doesn't exist";
	}

	public Object deleteCustomer(Integer customerId) {

		if (Model.customerDetailsNew.get(customerId) != null) {
			Model.customerDetailsNew.remove(customerId);
			return "deleted successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

	public String updateCustomer(Integer customerId, String customerName) {
		if (Model.customerDetailsNew.get(customerId) != null) {
			Customer cust = Model.customerDetailsNew.get(customerId);
			cust.setCustomerName(customerName);
			Model.customerDetailsNew.put(customerId, cust);
			return "updated successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

}
