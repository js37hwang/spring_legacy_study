package com.kopo.hkcode.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter") // bean id를 consolePrinter로 주겠다는 뜻
public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("console call " + message);
	}
}
