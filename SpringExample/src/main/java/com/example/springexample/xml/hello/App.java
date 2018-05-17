package com.example.springexample.xml.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		HelloBean bean = (HelloBean) context.getBean("helloBean2");
		bean.setValue("ramazan");
		
		bean.printValue();
	
	}

}
