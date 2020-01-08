package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.IMyEmpDao;
import com.mars.model.MyEmp;

public class MyBatisTest {
	
	
	@Test
	public void findAllTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(true);
		IMyEmpDao mapper = s.getMapper(IMyEmpDao.class);
		List<MyEmp> list = mapper.findEmpAndDept2();
		for(MyEmp e : list) {
			System.out.println(e.getEname() + "--" + e.getJob() + "--" + e.getDept());
		}
		
		s.close();
	}
}
