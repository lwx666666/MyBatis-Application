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
	
	/**
	 * 动态SQL
	 * if...
	 * @param e
	 * @return
	 */
	List<MyEmp> findAllByIf(MyEmp e);
	
	/**
	 * 动态SQL
	 * choose ... when..otherwise...
	 * @param e
	 * @return
	 */
	List<MyEmp> findListByChoose(MyEmp e);
	
	/**
	 * 动态SQL
	 * trim 解决where 1=1问题
	 * @param e
	 * @return
	 */
	List<MyEmp> finListdByTrim(MyEmp e);
	
	/**
	 * 动态SQL
	 * where 解决where 1=1问题
	 * @param e
	 * @return
	 */
	List<MyEmp> findListByWhere(MyEmp e);
}
