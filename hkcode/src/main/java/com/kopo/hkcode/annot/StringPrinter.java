package com.kopo.hkcode.annot;

import org.springframework.stereotype.Component;

@Component("stringPrinter")
public class StringPrinter implements Printer{
	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("string call "+message);
		
	}
}
