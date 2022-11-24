package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;
import com.bitacademy.container.user.User01;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto. Congfiguration (Annotation Scanning)
		// testApplicationContext01();

		// XML Bean Congfiguration (Explicit Congfiguration)
		testApplicationContext02();
	}

	// XML Auto. Congfiguration (Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/bitacademy/container/config/user/applicationContext01.xml");

		User01 user01 = ac.getBean(User01.class);
		System.out.println(user01.getName());

		// Bean의 id가 자동으로 설정된다.
		user01 = (User01) ac.getBean("user01");
		System.out.println(user01.getName());

//		user01 = (User01)ac.getBean("myuser"); // myuser라는 아이디를 가진 bean 호출
//		System.out.println(user01.getName());		

	}

	// XML Bean Congfiguration (Explicit Congfiguration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/bitacademy/container/config/user/applicationContext02.xml");

		User user = null;

		// id로 bean 가져오기
		user = (User) ac.getBean("user");
		System.out.println(user);
		
		// name으로 bean 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user);
		
		// Type으로 bean 가져오기
		// 1. 같은 Type의 bean이 두개 이상 있을때, Type으로 bean 가져오기는 실패한다
		// user = ac.getBean(User.class);
		// 2. id+type
		user = ac.getBean("user2",User.class);
		System.out.println(user);
		// 3. name+type
		user = ac.getBean("usr2",User.class);
		System.out.println(user);
		
		// 파라미터 2개로 생성된 bean 가져오기1 생성된 파라미터 순서대로 넣는 경우
		user = ac.getBean("user3",User.class);
		System.out.println(user);
		
		// 파라미터 2개로 생성된 bean 가져오기2 생성된 파라미터 순서와 다르게 넣는 경우
		user = ac.getBean("user4",User.class);
		System.out.println(user);
		
		// setter로 초기화 한 bean 가져오기
		user = ac.getBean("user5",User.class);
		System.out.println(user);
	}

}
