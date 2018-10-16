package com.study.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		
		//1.IoC컨테이너생성  
		AnnotationConfigApplicationContext context= 
				new AnnotationConfigApplicationContext(Config.class); 
		
		//2.HelloBean가져오기  
		Hello helloA=(Hello)context.getBean("hello"); 
		helloA.print(); 
		
		//3.HelloBean가져오기  
		Hello helloB=(Hello)context.getBean("hello1"); 
		helloB.print(); 
		
		//4.PrinterBBean가져오기   
		Printer printer = context.getBean("printerB",Printer.class); 
		helloA.setPrinter(printer); 
		helloA.print();
		
		//5. 싱글톤인지 확인
		System.out.println(helloA == helloB);
		context.close();
		

	}

}
