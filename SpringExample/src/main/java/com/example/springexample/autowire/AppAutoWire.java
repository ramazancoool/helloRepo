package com.example.springexample.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAutoWire {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAutoWire.class);
		
		FooService service = (FooService) context.getBean("fooService");
		
		service.method();
		
		FooFormatter formatter = context.getBean(FooFormatter.class);
		System.out.println(formatter.format());
	}

}
