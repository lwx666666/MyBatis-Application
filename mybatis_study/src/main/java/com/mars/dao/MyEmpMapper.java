package com.mars.dao;

import com.mars.model.MyEmp;

/**
 * 使用接口和映射文件绑定
 * 	1.绑定映射文件中的命名空间
 *  2.绑定映射文件中的方法id
 * 使用接口可以将具体实现和映射之间的分离，可以类型检查
 * @author libo
 *
 */
public interface MyEmpMapper {
	
	MyEmp findById(Integer id);
}
