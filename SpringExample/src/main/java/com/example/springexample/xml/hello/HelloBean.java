package com.example.springexample.xml.hello;

public class HelloBean {

	private String value;

	public void setValue(String value) {
		this.value = value;
	}
	
	public void printValue(){
		System.out.println("value: " + value);
	}
	
}
