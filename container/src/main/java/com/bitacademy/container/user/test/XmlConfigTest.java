package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User01;

public class XmlConfigTest {

	public static void main(String[] args) {
		//XML Auto. Congfiguration (Annotation Scanning)
		//testApplicationContext01();		

		//XML Bean Congfiguration (Explicit Congfiguration)
		testApplicationContext02();
	}
	
	//XML Auto. Congfiguration (Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext01.xml");
		
		User01 user01 = ac.getBean(User01.class);
		System.out.println(user01.getName());
		
		//Bean의 id가 자동으로 설정된다.
		user01 = (User01)ac.getBean("user01"); 
		System.out.println(user01.getName());
		
//		user01 = (User01)ac.getBean("myuser"); // myuser라는 아이디를 가진 bean 호출
//		System.out.println(user01.getName());		
		
	}
	
	//XML Bean Congfiguration (Explicit Congfiguration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext02.xml");
		
		
	}

}
