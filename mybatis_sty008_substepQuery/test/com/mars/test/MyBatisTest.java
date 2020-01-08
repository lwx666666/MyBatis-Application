package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.IMyDeptDao;
import com.mars.dao.IMyEmpDao;
import com.mars.model.MyDept;
import com.mars.model.MyEmp;

public class MyBatisTest {
	
	
	@Test
	public void substepQueryTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(true);
		IMyEmpDao mapper = s.getMapper(IMyEmpDao.class);
		MyEmp e = mapper.findById(7369);
		
		System.out.println(e.getEname());
		System.out.println(e.getDept().getDname());
		
		s.close();
	}
	
	@Test
	public void collectionQueryTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(true);
		IMyDeptDao mapper = s.getMapper(IMyDeptDao.class);
		MyDept dept = null;
		try {
//			dept = mapper.findEmpsByDeptno(10);
			dept = mapper.findDeptByDeptno(10);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		System.out.println(dept.getDname());
		System.out.println(dept.getEmps());
		
	}
	
	/**
	 * 缓存查询测试
	 * @throws IOException
	 */
	@Test
	public void cacheQueryTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(true);
		IMyEmpDao mapper = s.getMapper(IMyEmpDao.class);
		long start = System.currentTimeMillis();
		List<MyEmp> emps = mapper.findAll();
		System.out.println(emps);
		long end = System.currentTimeMillis();
		System.out.println("------------" + (end - start) + "-------------");
		s.close();
		// 使用二级缓存，在第一个缓存关闭后，第一个sqlSession会将其数据存入xml文件中，第二个sqlSession在查询数据时，会从xml缓存中取
		SqlSession s2 = ssf.openSession(true);
		IMyEmpDao mapper2 = s2.getMapper(IMyEmpDao.class);
		long start2 = System.currentTimeMillis();
		List<MyEmp> emps2 = mapper2.findAll();
		System.out.println(emps2);
		long end2 = System.currentTimeMillis();
		System.out.println("------------" + (end2 - start2) + "-------------");
		s2.close();
	}
}
