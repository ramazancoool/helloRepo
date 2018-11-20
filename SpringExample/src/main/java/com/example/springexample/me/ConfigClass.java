package com.example.springexample.me;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	@Bean
	public ICustomerService customerService(){
		return new CustomerService();
	}
	
	@Bean
	public CustomerClient customerClient(){
		return new CustomerClient();
	}
}
