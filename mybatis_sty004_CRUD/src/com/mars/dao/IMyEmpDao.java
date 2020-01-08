package com.mars.dao;

import java.util.List;

import com.mars.model.MyEmp;
/**
 * Dao接口使用注解方式操作SQL(不推荐)
 * 需要在mybatis核心配置中配置映射
 * @author libo
 *
 */
public interface IMyEmpDao {
	
	/**
	 * 查询所有
	 * @return MyEmp集合
	 */
	List<MyEmp> findAll();
	
	/**
	 * 通过id查询
	 * @param id
	 * @return MyEmp对象
	 */
	MyEmp findById(int id);
	
	/**
	 * 增加
	 * @param e
	 */
	void insert(MyEmp e);
	/**
	 * 修改
	 * @param e
	 */
	void update(MyEmp e);
}
