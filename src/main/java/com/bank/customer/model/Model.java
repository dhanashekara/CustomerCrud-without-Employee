package com.bank.customer.model;

import java.util.HashMap;
import java.util.Map;

import com.bank.customer.entity.Customer;

public class Model {
	
	//public static Map<Integer,Customer> customerDetails = new HashMap<Integer,Customer>();
	
	public static Map<Integer,Customer> customerDetailsNew = new HashMap<Integer,Customer>();

	public static Map<Integer, Customer> getCustomerDetailsNew() {
		return customerDetailsNew;
	}

	public static void setCustomerDetailsNew(Map<Integer, Customer> customerDetailsNew) {
		Model.customerDetailsNew = customerDetailsNew;
	}

	
}
