package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
					new GenericXmlApplicationContext(); //생성
		context.load("classpath:beans.xml"); // 설정
		
		context.refresh();
		
		Student student = context.getBean("student", Student.class); // 사용
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		context.close(); // 종료

	}

}
