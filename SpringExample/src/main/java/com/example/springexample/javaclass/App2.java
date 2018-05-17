package com.example.springexample.javaclass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springexample.xml.hello.HelloBean;

public class App2 {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloBean bean = (HelloBean) context.getBean("classHelloBean");
		
		bean.setValue("class config bean");
		bean.printValue();
	}

}
