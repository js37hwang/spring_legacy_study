package com.kopo.prac0601;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcTestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/datasource.xml");
	
		System.out.println("의존성 주입");
		
		DataSource ds = (DataSource) context.getBean("dataSource");
		
		System.out.println("연결 확인");
		
		try(Connection conn = ds.getConnection()){
			System.out.println("DB 연결 성공 : "+conn);
			
		}catch(Exception e) {
			System.out.println("DB 연결 실패 : "+ e.getMessage());
			e.printStackTrace();
		}	
	}

}
