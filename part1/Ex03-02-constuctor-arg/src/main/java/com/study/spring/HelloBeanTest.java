package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		String configLocation="classpath:beans.xml"; 
		//1.IoC컨테이너생성  
		GenericXmlApplicationContext context= 
				new GenericXmlApplicationContext(configLocation); 
		//2.HelloBean가져오기  
		Hello hello=(Hello)context.getBean("hello"); 
		hello.print(); 
		//3.PrinterBBean가져오기   
		Printer printer = context.getBean("printerB",Printer.class); 
		hello.setPrinter(printer); 
		hello.print();
		context.close();

	}

}
