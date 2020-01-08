package com.mars.mapper;

import com.mars.model.MyEmp;

public interface MyEmpMapper {

	MyEmp findEmpById(Integer id);
	
	int addEmp(MyEmp emp);
}
