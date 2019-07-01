package com.bank.customer.controller;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.entity.Customer;
import com.bank.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<String>(customerService.addCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/getCustomer{id}")
	public Object getCustomer(Integer customerId) {
		return customerService.getCustomer(customerId);

	}

	@DeleteMapping("/deleteCustomer")
	public Object deleteCustomer(Integer customerId) {

		return customerService.deleteCustomer(customerId);
	}

	@PutMapping("/updateCustomer")
	public Object updateCustomer(Integer customerId, String customerName) {

		return customerService.updateCustomer(customerId, customerName);

	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<JSONArray> getAllCustomers() throws IOException, ParseException {
		return new ResponseEntity<JSONArray>(customerService.getAllCustomers(), HttpStatus.OK);
	}

}
