package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.dto.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
//		itemMapper.selectByPrimaryKey(itemId);
		// 根据模板条件查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria(); // 创建约束
		criteria.andIdEqualTo(itemId); // 通过ID查询
		List<TbItem> items = itemMapper.selectByExample(example);
		TbItem item = null;
		if(null != items && items.size() > 0){
			item = items.get(0);
		}
		return item;
	}
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		PageHelper.startPage(page, rows);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(pageInfo.getList());
		return result;
	}
}
