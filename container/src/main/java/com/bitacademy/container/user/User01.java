package com.bitacademy.container.user;

import org.springframework.stereotype.Component;

@Component // @Component("myuser") myuser로 id 설정
public class User01 {
	
	public String getName() {
		
		return "둘리";
	}

}
