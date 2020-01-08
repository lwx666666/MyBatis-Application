package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.IEmpDao;
import com.mars.dao.IMyEmpDao;
import com.mars.model.MyEmp;


public class MyBatisTest {
	
	@Test
	public void testSelectEmp() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 设置为false则session不自动提交，默认为false
		SqlSession sqlSession = ssf.openSession(false);
		// 通过反射机制，获取接口代理对象
		IEmpDao empDao = sqlSession.getMapper(IEmpDao.class);
		System.out.println(empDao);
		MyEmp emp = empDao.findById(7566);
		System.out.println(emp);
		List<MyEmp> emps = empDao.findAll();
		for(MyEmp e : emps) {
			System.out.println(e);
		}
		sqlSession.commit();
	}
	
	@Test
	public void testSelectEmp2() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		// 设置为false则session不自动提交，默认为false
		SqlSession sqlSession = ssf.openSession(false);
		// 通过反射机制，获取接口代理对象
		IMyEmpDao empDao = sqlSession.getMapper(IMyEmpDao.class);
		System.out.println(empDao);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
		List<MyEmp> emps = empDao.findAll();
		for(MyEmp e : emps) {
			System.out.println(df.format(e.getHiredate()));
		}
		sqlSession.commit();
	}
}
