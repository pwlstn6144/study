package com.study.spring;

public class Hello {
	private String name;
	private String nickname;
	private Printer printer;

	public Hello() {
		super();
	}

	public String sayHello() {
		return "Hello " + name + " : " + nickname;
	}
	
	public Hello(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	public void setPrinter(Printer printer){ 
		this.printer=printer;  
	}

	public void print() {
		printer.print(sayHello());
	}
}
