package com.kopo.jshwang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

@RequestMapping("/hello") // 웹 브라우저에서 /hello로 접속하면 실행
	public String hello(Model model) {
		model.addAttribute("message", "Hello World from Spring MVC!");
		return "hello"; // /WEB-INF/views/hello.jsp 를 찾아감
	}
}