package com.example.springexample.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springexample.xmlautowired.FooService;

public class AppAutoWire {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAutoWire.class);
		
		FooService service = (FooService) context.getBean("fooService");
		
		service.method();
		
	}

}
