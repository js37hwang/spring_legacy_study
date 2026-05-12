package com.kopo.jshwang0512.pojo;

public class ConsolePrinter implements Printer {
	
	@Override
	public void print(String message) {
		System.out.println("console call : "+ message);
	}

}
