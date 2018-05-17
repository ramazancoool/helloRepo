package com.example.springexample.autowire;

import org.springframework.stereotype.Component;

@Component
public class FooFormatter {

	public String format(){
		return "foo";
	}
}
