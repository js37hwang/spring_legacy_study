package com.kopo.jshwang0512.pojo;

public class Hello {
	private String name;
	private Printer printer;
	
	public void setName(String n) {
		this.name = n;
	}
	public void setPrinter(Printer p) {
		this.printer = p;
	}
	public String sayHello() {
		return "Hello! "+ name;
	}
	public void print() {
		this.printer.print(sayHello());
	}
}
