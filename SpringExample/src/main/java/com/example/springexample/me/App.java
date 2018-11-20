package com.example.springexample.me;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigClass.class);
		CustomerClient client = applicationContext.getBean(CustomerClient.class);
		client.doSth(2);
		client.doSth(BigDecimal.ONE);
	}

}
