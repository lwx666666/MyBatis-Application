package com.mars.dao;

import com.mars.model.MyDept;

public interface IMyDeptDao {
	/**
	 * 根据id查询不到信息
	 * @param id
	 * @return
	 */
	MyDept findById(int id);
	
	MyDept findEmpsByDeptno(Integer deptno);
	
	MyDept findDeptByDeptno(Integer deptno);
}
