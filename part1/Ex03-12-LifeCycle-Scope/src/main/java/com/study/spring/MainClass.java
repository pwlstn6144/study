package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:beans.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("=============================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("전우치");
		student2.setAge(25);
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		System.out.println("=============================");
		
		//객체가 저장하는 value
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		else {
			System.out.println("student1 != student2");
		}
		
		//객체 자체 비교
		System.out.println(student1 == student2);
		
		ctx.close();

	}

}
