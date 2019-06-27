package com.bank.customer.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.anyInt;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.customer.constants.Constants;
import com.bank.customer.entity.Customer;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerService {

	@InjectMocks
	CustomerService customerService;

	@Mock
	Constants constant;
	
	@Test
	public void testAddCustomer() {
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
		CustomerService customerService1 = mock(CustomerService.class);

		Integer id=1;
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("leela");
		customer.setCustomerRole("admin");
		customer.setPhonerNumber("132456789");
		
		Map<Integer, Customer> map = new HashMap<Integer, Customer>();
		map.put(1, customer);
		
		//Set<Map.Entry<Integer, Customer>> entrySet = map.entrySet();
	//	Map mockAvailableActions = mock(Map.class);
		//when(mockAvailableActions.entrySet()).thenReturn(entrySet);
		
		when(customerService.getCustomer(anyInt())).thenReturn(customer);
		
		Object actual =  customerService1.getCustomer(id);
		System.out.println(actual);
		assertEquals(customer, actual);
	}
}
