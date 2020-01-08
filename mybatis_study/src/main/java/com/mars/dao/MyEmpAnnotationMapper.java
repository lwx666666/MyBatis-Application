package com.mars.dao;

import org.apache.ibatis.annotations.Select;

import com.mars.model.MyEmp;
/**
 * 基于注解的接口映射用于不重要的，简单的为了开发快速的sql可以使用注解
 * @author libo
 *
 */
public interface MyEmpAnnotationMapper {
	// 基于注解的映射接口
	@Select("select empno,ename empName,mgr,hiredate,comm,sal,job from myemp where empno=#{id}")
	MyEmp findById(Integer id);
}
