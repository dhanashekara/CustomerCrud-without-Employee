package com.bank.customer.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.bank.customer.entity.Customer;
import com.bank.customer.model.Model;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {

	ObjectMapper mapper = new ObjectMapper();

	public String addCustomer(Customer customer) throws IOException {

		if (Model.customerDetailsNew.get(customer.getCustomerId()) == null) {
			Model.customerDetailsNew.put(customer.getCustomerId(), customer);

			File file = new File("src/main/resources/static/customer.json");
			FileWriter fw = new FileWriter(file);
			mapper.writeValue(fw, Model.customerDetailsNew);
			fw.close();

			return "customer added successfully";
		} else {
			return "customer already exists";
		}

		/*
		 * JSONParser jsonParser = new JSONParser();
		 * 
		 * FileReader reader = new
		 * FileReader("src/main/resources/static/customer.json");
		 * 
		 * Object obj = jsonParser.parse(reader);
		 * 
		 * JSONArray customerList = (JSONArray) obj;
		 */

		// System.out.println("customerList "+customerList);
		// System.out.println(customerList.get(100));
		// Iterator<JSONObject> it = customerList.iterator();

		// System.out.println("if "+it.next().containsKey(customer.getCustomerId()+""));

		/*
		 * while(it.hasNext()) { System.out.println("object before "+it.next());
		 */

		// JSONObject jsonObject = (JSONObject)
		// it.next().get(customer.getCustomerId()+"");
		// System.out.println("object after "+jsonObject);
		// }

		/// System.out.println(customerList.getJSONObject);

		/*
		 * for(int i=0;i<customerList.size();i++) { JSONObject jsn = (JSONObject)
		 * customerList.get(i); String key = jsn.getStr }
		 */

		// JSONObject object = (JSONObject) customerList.get(index)

		/*
		 * for(JSONObject object:customerList.g) {
		 * 
		 * }
		 */
		/*
		 * customerList.forEach(object ->{ JSONObject temp = object.get("nbh"); });
		 */

		// JSONObject employeeObject = (JSONObject)
		// customerList.get(customer.getCustomerId());
		/*
		 * if (employeeObject.containsKey(customer.getCustomerId())) { return
		 * "Customer already exist"; } else { // customerList.add(customer); JSONObject
		 * customerDetailsJSON = new JSONObject(); customerDetailsJSON.put("customerId",
		 * customer.getCustomerId()); customerDetailsJSON.put("customerName",
		 * customer.getCustomerName()); customerDetailsJSON.put("customerRole",
		 * customer.getCustomerRole()); customerDetailsJSON.put("phonerNumber",
		 * customer.getPhonerNumber());
		 * 
		 * JSONObject customerJSON = new JSONObject();
		 * customerJSON.put(customer.getCustomerId(), customerDetailsJSON);
		 * customerList.add(customerJSON);
		 * 
		 * System.out.println(customerList); return "customer added successfully"; }
		 */

		// customerList.add(customer);
		// return null;

	}

	public Object getCustomer(Integer customerId) {
		if (Model.customerDetailsNew.get(customerId) != null)
			return Model.customerDetailsNew.get(customerId);
		else
			return "Customer Doesn't exist";
	}

	public Object deleteCustomer(Integer customerId) throws IOException {

		if (Model.customerDetailsNew.get(customerId) != null) {
			Model.customerDetailsNew.remove(customerId);
			File file = new File("src/main/resources/static/customer.json");
			FileWriter fw = new FileWriter(file);
			mapper.writeValue(fw, Model.customerDetailsNew);
			fw.close();
			return "deleted successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

	public String updateCustomer(Integer customerId, String customerName) throws IOException {
		if (Model.customerDetailsNew.get(customerId) != null) {
			Customer cust = Model.customerDetailsNew.get(customerId);
			cust.setCustomerName(customerName);
			Model.customerDetailsNew.put(customerId, cust);

			File file = new File("src/main/resources/static/customer.json");
			FileWriter fw = new FileWriter(file);
			mapper.writeValue(fw, Model.customerDetailsNew);
			fw.close();
			return "updated successfully";
		} else {
			return "Customer Doesn't exist";
		}
	}

	/*
	 * public JSONArray getAllCustomers() throws IOException, ParseException {
	 * JSONParser jsonParser = new JSONParser();
	 * 
	 * FileReader reader = new
	 * FileReader("src/main/resources/static/customer.json");
	 * 
	 * Object obj = jsonParser.parse(reader);
	 * 
	 * JSONArray customerList = (JSONArray) obj; System.out.println(customerList);
	 * return customerList;
	 * 
	 * }
	 */

	public Object getAllCustomers() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		FileReader reader = new FileReader("src/main/resources/static/customer.json");

		Object obj = jsonParser.parse(reader);

		// JSONArray customerList = (JSONArray) obj;
		System.out.println(obj);
		return obj;
	}

	public String addMultipleCustomers(ArrayList<Customer> customer) {

		StringBuilder sb = new StringBuilder();

		customer.forEach(cust -> {
			if (Model.customerDetailsNew.get(cust.getCustomerId()) == null) {
				Model.customerDetailsNew.put(cust.getCustomerId(), cust);
			} else {
				sb.append(cust.getCustomerId()+"\n");
			}
		});

		if (sb.length() > 0) {
			return "These customers with following id's are already exists:\n" + sb;
		} else {
			return "Customer added successfully";
		}
	}

}
