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
	 * 根据id获取MyEmp的对象信息
	 * @param id
	 * @return
	 */
	MyEmp findById(int id);
	
	List<MyEmp> findAll();
	
	List<MyEmp> findEmpsByDeptno(Integer deptno);
}
