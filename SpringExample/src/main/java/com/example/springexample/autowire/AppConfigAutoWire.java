package com.example.springexample.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigAutoWire {

	@Bean
	public FooFormatter fooFormatter(){
		return new FooFormatter("bean 1");
	}

	@Bean
	public FooService fooService(){
		return new FooService();
	}
}
