package com.example.springexample.me;

import java.util.HashMap;
import java.util.Map;

public class CustomerService implements ICustomerService {

	private Map<Number, String> customerMap = new HashMap<Number, String>(){
		private static final long serialVersionUID = 1109707075824550403L;

		{
			put(1, "a");
			put(2, "b");
			put(3, "c");
		}
	};
	
	public String getCustomerName(Number customerNo) {
		return customerMap.get(customerNo);
	}
	
}
