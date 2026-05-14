package com.kopo.hkcode; // 이 패키지 선언이 실제 폴더 경로와 일치해야 합니다.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kopo.hkcode.pojo.Hello;

@Controller // 이 어노테이션이 반드시 있어야 스프링이 알아봅니다!
public class HelloController {
	
	
	@Autowired
    private Hello hello; // 스프링이 beans.xml에 있는 hello 객체를 자동으로 꽂아줌	
	
	@RequestMapping(value = "/helloTest", method = RequestMethod.GET)
    public String helloTest(Model model) {
        // 우리가 만든 POJO의 기능을 사용해서 메시지를 생성
        String result = hello.sayHello(); 
        
        // 생성된 메시지를 'msg'라는 이름으로 JSP에 전달
        model.addAttribute("msg", result);
        
        return "hellopojo"; // views/hello.jsp 파일을 찾아가라!
    }
	
	@RequestMapping("/hello") // 웹 브라우저에서 /hello로 접속하면 실행
    public String hello(Model model) {
        model.addAttribute("message", "Hello World from Spring MVC!");
        return "hello"; // /WEB-INF/views/hello.jsp 를 찾아감
    }
}
