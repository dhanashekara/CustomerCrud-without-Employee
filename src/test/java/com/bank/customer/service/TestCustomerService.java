package com.bank.customer.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.customer.entity.Customer;
import com.bank.customer.model.Model;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerService {

	@InjectMocks
	CustomerService customerService;

	@Mock
	Model model;

	@Test
	public void testAddCustomer() throws IOException, ParseException {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("leela");
		customer.setCustomerRole("admin");
		customer.setPhonerNumber("132456789");
		String msg = customerService.addCustomer(customer);
		assertEquals("customer added successfully", msg);
	}

	@Test
	public void testgetCustomer() {
		// CustomerService customerService1 = mock(CustomerService.class);
		// Model model = mock(Model.class);

		Integer id = 1;
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("leela");
		customer.setCustomerRole("admin");
		customer.setPhonerNumber("132456789");

		Map<Integer, Customer> map = new HashMap<Integer, Customer>();
		map.put(1, customer);

		// Set<Map.Entry<Integer, Customer>> entrySet = map.entrySet();
		// Map mockAvailableActions = mock(Map.class);
		// when(mockAvailableActions.entrySet()).thenReturn(entrySet);

		// when(customerService1.getCustomer(anyInt())).thenReturn(customer);
		//when(model.getCustomerDetailsNew().get(anyInt())).thenReturn(customer);

		Object actual = (Customer)customerService.getCustomer(id);
		//System.out.println(actual);
		//assertEquals(customer.getCustomerId(), actual.getCustomerId());
		
		Customer actualConverted = (Customer) actual;
		
		assertEquals(customer.getCustomerId(), actualConverted.getCustomerId());

	}

	@Test
	public void updateCustomer() {

		Integer id = 1;
		String custName = "xyz";
		String actual = customerService.updateCustomer(id, custName);
		assertEquals("updated successfully", actual);
	}

	@Test
	public void deleteCustomer() {
		Integer id = 1;
		Object actual = customerService.deleteCustomer(id);
		assertEquals("Customer Doesn't exist", actual);
	}

}
