package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.model.MyEmp;

public class MyBatisTest {
	
	@Test
	public void testSelectEmp() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = sf.openSession();
//		MyEmp emp = s.selectOne("com.mars.model.MyEmp.findOne", 7698);
		List<MyEmp> emps = s.selectList("com.mars.model.MyEmp.findAll");
		for(MyEmp e : emps) {
			System.out.println(e);
		}
		
	}
}
