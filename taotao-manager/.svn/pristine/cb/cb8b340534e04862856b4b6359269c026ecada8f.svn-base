package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	private String showIndex(){
		return "index"; // 返回逻辑视图，经视图解析器解析为物理视图
	}
	
	// 页面切换
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}
}
