package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		
		String configLocation = "classpath:beans.xml";
		
		//1.IoC컨테이너생성  
		ApplicationContext context= 
				new GenericXmlApplicationContext(configLocation); 
		
		//2.HelloBean가져오기  
		Hello hello=(Hello)context.getBean("hello"); 
		
		System.out.println(hello.getDriverClass());
		System.out.println(hello.getUrl());
		System.out.println(hello.getUsername());
		System.out.println(hello.getPassword());
		
		
		

	}

}
