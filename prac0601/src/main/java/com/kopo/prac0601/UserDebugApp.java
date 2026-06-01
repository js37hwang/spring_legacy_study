package com.kopo.prac0601;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kopo.user.dao.UserDAO;
import com.kopo.user.vo.UserVO;


public class UserDebugApp {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(
				"classpath:spring/datasource.xml",
			    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"
			);

		try  {
			UserDAO dao = (UserDAO) context.getBean("userDao");

			UserVO newUser = new UserVO();
			
			newUser.setName("testuser");
			newUser.setCity("Seoul");
			newUser.setUserId("testuser2");
			newUser.setGender("female");
			
			dao.insert(newUser);
			
			String targetId = newUser.getUserId();
			UserVO user = dao.read(targetId);

			if (user != null) {
				System.out.println(user.toString());
			} else {
				System.out.println("user not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
