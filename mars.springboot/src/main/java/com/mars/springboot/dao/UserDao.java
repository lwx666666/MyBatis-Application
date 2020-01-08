package com.mars.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mars.springboot.model.User;

public class UserDao {
	
	@Autowired
	DataSource boneCpDataSource;
	public List<User> findAllUsers(){
		List<User> users = new ArrayList<User>();
		User u = null;
		for(int i = 0; i < 5; i++) {
			u = new User();
			u.setId(i+1);
			u.setName("u" + i);
			users.add(u);
		}
		System.out.println(boneCpDataSource);
		
		return users;
	}
}
