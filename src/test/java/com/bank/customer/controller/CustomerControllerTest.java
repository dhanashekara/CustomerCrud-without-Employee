package com.bank.customer.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bank.customer.entity.Customer;
import com.bank.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, CustomerController.class })
@WebAppConfiguration
public class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;

	private MockMvc mockMvc;

	@Mock
	private CustomerService customerService;

	@Before
	public void Setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	public static String asJsonString(final Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);

	}

	@Test
	public void tedtAddCustomer() throws JsonProcessingException, Exception {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("leela");
		customer.setCustomerRole("admin");
		customer.setPhonerNumber("132456789");
		when(customerService.addCustomer(customer)).thenReturn("customer added successfully");
		this.mockMvc.perform(
				post("/customer/addCustomer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)));

		ResponseEntity<String> cust = customerController.addCustomer(customer);
		assertEquals(200, cust.getStatusCodeValue());
	}

	@Test
	public void testgetCustomer() throws JsonProcessingException, Exception {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("leela");
		customer.setCustomerRole("admin");
		customer.setPhonerNumber("132456789");
		when(customerService.getCustomer(customer.getCustomerId())).thenReturn(customer);
		this.mockMvc.perform(get("/customer/getCustomer{id}",555).contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)));
		Customer cust = (Customer) customerController.getCustomer(customer.getCustomerId());
		assertEquals(customer, cust);
	}
	
	@Test
	public void testUpdateCustomer() throws Exception {
		
		Integer customerId =1;
		String customerName = "xyz";
		
		when(customerService.updateCustomer(customerId, customerName)).thenReturn("updated successfully");
		this.mockMvc.perform(put("/customer/updateCustomer").contentType(MediaType.APPLICATION_JSON));
				
		String actual = (String) customerController.updateCustomer(customerId, customerName);
		
		assertEquals("updated successfully", actual);
	}
	
	@Test
	public void testDeleteCustomer() throws Exception {
		
		Integer customerId =1;
		
		when(customerService.deleteCustomer(customerId)).thenReturn("deleted successfully");
		this.mockMvc.perform(delete("/customer/deleteCustomer").contentType(MediaType.APPLICATION_JSON));
				
		String actual = (String) customerController.deleteCustomer(customerId);
		
		assertEquals("deleted successfully", actual);

	}

}
