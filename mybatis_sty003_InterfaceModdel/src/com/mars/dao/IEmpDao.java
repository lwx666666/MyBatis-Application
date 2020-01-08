package com.mars.dao;

import java.util.List;

import com.mars.model.MyEmp;
/**
 * 使用接口模式自动创建对象
 * @author libo
 *
 */
public interface IEmpDao {
	MyEmp findById(int id);
	List<MyEmp> findAll();
}
