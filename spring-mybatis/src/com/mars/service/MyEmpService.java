package com.mars.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.mapper.MyEmpMapper;
import com.mars.model.MyEmp;

@Service
@Transactional
public class MyEmpService {
	
	@Resource
	private MyEmpMapper mapper;
	
	public MyEmp getEmp() {
		MyEmp emp = mapper.findEmpById(2112);
		
		return emp;
	}
	public int addEmp(MyEmp emp) {
		int num = mapper.addEmp(emp);
		int i = 1 / 0;
		return num;
	}
}
