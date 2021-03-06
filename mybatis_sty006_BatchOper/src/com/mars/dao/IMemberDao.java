package com.mars.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.mars.model.Member;
/**
 * 接口传参的三种形式：
 * 1.单个参数，mybatis不做特殊处理
 * 2.传入一个对象，在sql语句中指定对象的属性
 * 		#{对象属性名}
 * 3.传入多个参数，mybatis会做特殊处理，将传入的参数自动封装为Map集合
 * 		key为param1...paramN
 * 		value为传入的参数值
 * 		可以使用注解指定参数名称@Param("指定名称")
 * 4.直接使用Map进行数据参数传递
 * 5.在接口的方法中传入Collection集合，类型为List和Set，数组
 * 		Mybatis会做特殊处理，将集合或者数组封装到一个Map中
 * 		如果是List或者Set，则key是list
 * 		如果是数组则key是array
 * 		
 * @author libo
 *
 */
public interface IMemberDao {
	
	/**
	 * 查询所有
	 * @return Member集合
	 */
	List<Member> findAll();
	
	/**
	 * 通过id查询
	 * @param id
	 * @return Member对象
	 */
	Member findById(int id);
	
	/**
	 * 增加
	 * @param m
	 */
	void insert(Member m);
	
	/**
	 * 修改
	 * @param m
	 */
	void updateById(Member m);
	
	/**
	 * 删除
	 */
	void deleteById(int id);
	
	/**
	 * 按照名称查询
	 * @param name
	 * @return Member对象
	 */
	Member findByName(String name);
	
	/**
	 * 多参数查询
	 * @param name
	 * @param email
	 * @return Member对象集合
	 */
	List<Member> findByNameAndEmail(@Param("name") String name,@Param("email") String email);
	
	/**
	 * Map形式传参
	 * @param map
	 * @return Member对象集合
	 */
	List<Member> findByNameAndEmail2(Map<String,?> map);
	
	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	public int deleteByList(List<Integer> list);
	
	/**
	 * 批量删除
	 * @param array
	 * @return
	 */
	public int deleteByArray(String [] name);
	
	/**
	 * 批量新增
	 * @param set
	 * @return
	 */
	public int insertBySet(@Param("members") Set<Member> members);
}
