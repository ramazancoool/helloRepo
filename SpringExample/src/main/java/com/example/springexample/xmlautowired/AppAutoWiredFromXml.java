package com.example.springexample.xmlautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAutoWiredFromXml {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		FooService bean = (FooService) context.getBean("fooService");
		
		bean.method();
	}
}
