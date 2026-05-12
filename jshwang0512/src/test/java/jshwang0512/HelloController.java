package jshwang0512;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kopo.jshwang0512.pojo.Hello;
import com.kopo.jshwang0512.pojo.Printer;

public class HelloController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/beans.xml");
		
		Hello hello = (Hello)context.getBean("hello");
		
		System.out.println(hello.sayHello());
		
		hello.print();
		
		Printer printer = context.getBean("printerC", Printer.class);
		printer.print("test");
		
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println("둘이 같은 객체임??? "+ (hello == hello2));
		
	}

}
