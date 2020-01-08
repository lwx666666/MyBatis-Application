package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.MyEmpAnnotationMapper;
import com.mars.dao.MyEmpMapper;
import com.mars.model.MyEmp;
/**
 * mybatis是一个半自动化的orm框架
 * mybatis的操作步骤：
 * 	1.需要一个全局配置xml，配置数据源连接信息
 *  2.创建需要操作的实体类
 *  3.sql映射文件xxxMapper.xml，配置sql语句，以及sql的封装规则，和实体类之间的映射关系
 *  4.sql映射文件的path注册在全局配置文件中
 *  5.根据全局配置文件获取SqlSessionFactory对象
 *  6.使用SqlSessionFactory得到sqlSession对象执行增删改查操作
 * @author libo
 *
 */
public class EmpTest {
	
	@Test
	public void empTest() {
		Reader reader = null;
		SqlSession session = null;
		try {
			// 根据配置文件创建SqlSessionFactory
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			// 获取SqlSession对象
			session = sessionFactory.openSession();
			// 使用唯一标识找到执行的sql语句，唯一标识：命名空间.id，旧版本
			MyEmp emp = session.selectOne("com.mars.dao.MyEmpMapper.findOne",7369);
			System.out.println(emp.getEmpName());
			System.out.println(emp.getHiredate());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			session.close();
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void mapperTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		MyEmpMapper mapper = sqlSession.getMapper(MyEmpMapper.class);
		MyEmp emp = mapper.findById(7654);
		System.out.println(emp.getEmpName());
		sqlSession.close();
		reader.close();
	}
	
	@Test
	public void mapperAnnotationTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpAnnotationMapper mapper = sqlSession.getMapper(MyEmpAnnotationMapper.class);
		MyEmp emp = mapper.findById(7654);
		System.out.println(emp.getEmpName());
		sqlSession.close();
		reader.close();
	}
}
