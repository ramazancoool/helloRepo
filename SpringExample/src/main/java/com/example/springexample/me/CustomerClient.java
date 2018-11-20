package com.example.springexample.me;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerClient {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private ICustomerService iservice;
	
	public void doSth(Number number) {
		System.out.println(service.getCustomerName(number));
		System.out.println(iservice.getCustomerName(number));
	}
}
