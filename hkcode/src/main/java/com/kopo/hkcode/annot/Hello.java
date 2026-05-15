package com.kopo.hkcode.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello") // 컴포넌트명인 Hello 생략 가능
public class Hello {
	
	@Value("hkcode") // Hello 클래스 호출 즉시 name에 hkcode가 값으로 들어감
	private String name;
	
	@Autowired
	@Qualifier("stringPrinter") // 동일 인터페이스(printer)를 상속받은 클래스가 여러개일때, 정확히 지목하기 위해 사용
	private Printer printer;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public String sayHello() {
		return "Hello "+ name;
	} 
	public void print() {
		this.printer.print(sayHello());
	}
}
