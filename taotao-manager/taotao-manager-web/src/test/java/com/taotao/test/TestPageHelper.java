package com.taotao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
/**
 * 分页插件测试
 * @author libo
 *
 */
public class TestPageHelper {
	
	@Test
	public void testPageHelper(){
		// 获取Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		// 设置分页
		PageHelper.startPage(1, 30); // 分页只对第一个执行的查询有效
		// 执行sql查询
		TbItemExample example = new TbItemExample();
		List<TbItem> items = mapper.selectByExample(example);
		// 对查询出的数据进行分页
		PageInfo<TbItem> info = new PageInfo<>(items);
		int pages = info.getPages();
		System.out.println("pages：" + pages);
		long total = info.getTotal();
		System.out.println("total：" + total);
		int pageSize = info.getPageSize();
		System.out.println("pageSize：" + pageSize);
	}
}
