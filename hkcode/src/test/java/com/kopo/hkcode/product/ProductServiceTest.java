package com.kopo.hkcode.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductServiceTest {
	public static void main(String[] args) {
		// 배경 지식으로 사용하려는 beans 파일 연결 시켜줌
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/beans_product.xml");
	
		// 우리가 테스트 하려는 클래스..! bean에서 준 id와 맞추어 가져와야 함
		// 가져오며 테스트 하려는 클래스 타입으로 캐스팅 진행한다 -> 방법 2개 존재
		ProductService productService = (ProductService)context.getBean("productService");
		// ProductService productService = context.getBean("productService", ProductService.class);
	
		String res = productService.getMaxQtyByRegion("A44");
		
		System.out.println(res);
	}

}
