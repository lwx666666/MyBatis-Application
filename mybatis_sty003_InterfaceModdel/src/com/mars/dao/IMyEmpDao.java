package com.mars.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mars.model.MyEmp;
/**
 * Dao接口使用注解方式操作SQL(不推荐)
 * 需要在mybatis核心配置中配置映射
 * @author libo
 *
 */
public interface IMyEmpDao {
	
	@Select("SELECT * FROM myemp")
	List<MyEmp> findAll();
}
