package com.example.springexample.autowire;

import org.springframework.stereotype.Component;

@Component
public class FooFormatter {

	private String param;
	
	public FooFormatter(String param) {
		this.param = param;
	}
	
	public String format(){
		return "FooFormatter " + param;
	}
}
