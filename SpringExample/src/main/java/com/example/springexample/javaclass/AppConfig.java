package com.example.springexample.javaclass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springexample.xml.hello.HelloBean;


@Configuration
public class AppConfig {

	@Bean(name="classHelloBean")
	public HelloBean getHelloBean(){
		return new HelloBean();
	}
}
