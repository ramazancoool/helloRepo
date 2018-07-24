package com.example.springexample.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class FooService {

	@Autowired
	FooFormatter fooFormatter;
	
	public void method() {
		System.out.println("method, " +fooFormatter.format());
	}

}
