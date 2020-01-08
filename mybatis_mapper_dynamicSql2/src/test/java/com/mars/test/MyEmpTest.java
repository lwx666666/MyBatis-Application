package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mars.dao.MyEmpMapperDynamicSQL;
import com.mars.model.MyDept;
import com.mars.model.MyEmp;

public class MyEmpTest {
	static SqlSessionFactory sqlSessionFactory = null;
	@BeforeClass
	public static void before() {
		
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	/*	@Test
	public void testDynamicSQL() throws ParseException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		MyEmp emp = new MyEmp();
		emp.setEname(null);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Date hiredate = sdf.parse("1981-12-10");
		emp.setHiredate(null);
		emp.setSal(2500.0);
		try {
			List<MyEmp> emps = mapper.findEmpsByChoose(emp);
			System.out.println(emps);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testAdd() throws ParseException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		MyEmp emp = new MyEmp();
		//empno,ename,job,hiredate,sal
		emp.setEmpno(8999);
		emp.setEname("HERBE");
		emp.setJob("SALESMAN");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = sdf.parse("1981-12-10");
		emp.setHiredate(hiredate);
		emp.setSal(2500.0);
		try {
			int num = mapper.addEmp(emp);
			System.out.println(num);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}*/
	
/*	@Test
	public void testUpdateSql() throws ParseException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		MyEmp emp = new MyEmp();
		emp.setEmpno(8999);
		emp.setEname("小明");
//		emp.setJob("worker");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = sdf.parse("2011-02-10");
//		emp.setHiredate(hiredate);
		emp.setSal(3530.0);
		try {
			int num = mapper.updateEmpByDynamicSql(emp);
			System.out.println(num);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}*/
	
	@Test
	public void testForeachSql() throws ParseException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		
		try {
			List<MyEmp> emps = mapper.findEmpsByForeach(Arrays.asList(7902, 7788));
			System.out.println(emps);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testBatchInsertSql() throws ParseException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		List<MyEmp> emps = new ArrayList<MyEmp>();
		MyEmp emp1 = new MyEmp(1238,"T3","TJ3",null,new Date(),1299.0,null,new MyDept(40));
		MyEmp emp2 = new MyEmp(1239,"T4","TJ4",null,new Date(),1889.0,null,new MyDept(40));
		emps.add(emp1);
		emps.add(emp2);
		try {
			int num = mapper.batchInsert(emps);
			System.out.println(num);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
}
