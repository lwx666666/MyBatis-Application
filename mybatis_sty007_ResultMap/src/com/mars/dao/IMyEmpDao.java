package com.mars.dao;

import java.util.List;

import com.mars.model.MyEmp;
/**
 * 
 * @author libo
 *
 */
public interface IMyEmpDao {
	
	/**
	 * 查询所有
	 * @return MyEmp集合
	 */
	List<MyEmp> findEmpAndDept();
	
	List<MyEmp> findEmpAndDept2();
}
