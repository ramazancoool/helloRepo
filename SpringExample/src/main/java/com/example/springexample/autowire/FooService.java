package com.example.springexample.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class FooService {

	@Autowired
	FooFormatter formatter;
	
	public void method(){
		formatter.format();
	}
}
