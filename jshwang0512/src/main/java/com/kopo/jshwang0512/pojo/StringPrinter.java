package com.kopo.jshwang0512.pojo;

public class StringPrinter implements Printer {

	@Override
	public void print(String message) {
		System.out.println("String call : "+message);
	}
}
