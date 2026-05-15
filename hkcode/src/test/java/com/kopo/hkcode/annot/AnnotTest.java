package com.kopo.hkcode.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kopo.hkcode.annot.Hello;

public class AnnotTest {

	public static void main(String[] args) {
		// 1 사용하려는 beans 파일을 배경 지식으로 연동시켜준다
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/beans_annot.xml");
		
		// 2 태스트 하려는 클래스 가져오기 
		Hello hello = (Hello)context.getBean("hello"); // component 어노테이션으로 준 id값을 가져와야 하는거
		
		// 3 결과 출력- stringPrint 클래스에서 hkcode를 찍을것임
		String res = hello.sayHello();
		
		if(!res.contains("hkcode")) {
			System.out.println("잘못됨!");
		}else {
			System.out.println("테스트 완 : "+ res);
		}
		
	}

}
