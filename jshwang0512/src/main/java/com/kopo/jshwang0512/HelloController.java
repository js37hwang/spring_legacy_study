package com.kopo.jshwang0512;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kopo.jshwang0512.pojo.Hello;

@Controller
public class HelloController {
	
	@Autowired // spring아 bean에서 Hello 객체 찾아서 알아서 주입해주라= 의존성 주입
	private Hello hello;
	// @Autowired를 사용하지 않는다면 개발자가 직접 new를 사용하여 선언
	
	// ① /hello — Model에 직접 문자열 담기
	@RequestMapping("/hello") 
	public String hello(Model model) {
	
		model.addAttribute("message", "Hello World from Spring MVC!");
		return "hello"; // /WEB-INF/views/hello.jsp 를 찾아감
	}
	
	// ② /helloTest — Hello bean의 메서드 결과를 Model에 담기
	@RequestMapping("/helloTest") 
	public String helloTest(Model model) {
	
		String res = hello.sayHello();
		model.addAttribute("message", res);
		return "hello";
	}
	
	// ③ /pojo — 다른 key("msg"), 다른 JSP
	@RequestMapping("/pojo") 
	public String pojo(Model model) {
	
		String res = hello.sayHello()+" hey!!!";
		model.addAttribute("msg", res);
		return "helloPojo"; 
	}
}