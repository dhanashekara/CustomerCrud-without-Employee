package com.bank.customer.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.bank.customer.entity.Customer;
import com.bank.customer.model.Model;

@Service
public class CustomerService {

	public String addCustomer(Customer customer)  {

		if (Model.customerDetailsNew.get(customer.getCustomerId()) == null) {
			Model.customerDetailsNew.put(customer.getCustomerId(), customer);
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

	public JSONArray getAllCustomers() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		FileReader reader = new FileReader("src/main/resources/static/customer.json");

		Object obj = jsonParser.parse(reader);

		JSONArray customerList = (JSONArray) obj;
		System.out.println(customerList);
		return customerList;

	}

}
