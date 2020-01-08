package com.mars.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.springboot.dao.UserDao;
import com.mars.springboot.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll() {
		
		return userDao.findAllUsers();
	}
	
}
