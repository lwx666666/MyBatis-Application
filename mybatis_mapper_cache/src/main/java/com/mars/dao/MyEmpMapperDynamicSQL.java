package com.mars.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mars.model.MyEmp;

public interface MyEmpMapperDynamicSQL {
	
	List<MyEmp> findEmpsByIf(MyEmp emp);
	
	List<MyEmp> findEmpsByIf2(MyEmp emp);
	
	List<MyEmp> findEmpsByChoose(MyEmp emp);
	
	int addEmp(MyEmp emp);
	
	int updateEmpByDynamicSql(MyEmp emp);
	
	List<MyEmp> findEmpsByForeach(@Param("empnos") List<Integer> empnos);
	
	int batchInsert(@Param("emps") List<MyEmp> emps);
	
	List<MyEmp> findEmpsInnerParam(MyEmp emp);

	MyEmp findEmpById(Integer id);
}
