package com.mars.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.UserMapper;
import com.mars.model.User;

public class UserTest {
	@Test
	public void userAddTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(null);
		user.setAge(25);
		user.setEmail("hello@ll.com");
		user.setUsername("菜菜");
		mapper.addUser(user);
		System.out.println(user.getId());
		sqlSession.commit(); // 增删改必须提交事务
		sqlSession.close();
		reader.close();
	}
}
