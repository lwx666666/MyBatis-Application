package com.mars.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.mars.model.User;

public interface UserMapper {
	// 返回一条记录的map封装，key是列名，值是列对应的值
	Map<String,Object> getUserAsMap(int id);
	// 返回一条map记录，key是这条记录的主键，值是主键对用行的数据封装的User对象
	@MapKey("id")
	Map<Integer,User> getUserAsMap2(String username);
	
	Integer addUser(User user);
	// 如果参数不是Map类型或者对象类型的话，在map.xml中则不能使用${}取值
	List<User> selectByNameLike(String username);
	
	List<User> getUsersResultMap();
}
