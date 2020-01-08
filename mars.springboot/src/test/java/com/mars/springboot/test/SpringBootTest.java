package com.mars.springboot.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mars.springboot.configuration.SpringConfiguration;
import com.mars.springboot.model.User;
import com.mars.springboot.service.UserService;

public class SpringBootTest {
	
	@Test
	public void queryUsers() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		UserService service = context.getBean(UserService.class);
		List<User> users = service.findAll();
		for(User u : users) {
			System.out.println(u.getName());
		}
		
		context.close();
	}
}
