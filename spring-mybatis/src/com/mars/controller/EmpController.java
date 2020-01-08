package com.mars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mars.mapper.MyEmpMapper;
import com.mars.model.MyEmp;
import com.mars.service.MyEmpService;

@Controller
public class EmpController {
	
	@Autowired
	private MyEmpMapper mapper;
	@Autowired
	private MyEmpService service;
	@RequestMapping("/getEmp")
	public ModelAndView getEmp() {
		MyEmp emp = mapper.findEmpById(7369);
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.addObject("emp",emp);
		modelAndview.setViewName("success");
		System.out.println(emp);
		return modelAndview;
	}
	
	@RequestMapping("/getEmp2")
	public String getEmp2(Model model) {
		System.out.println("service"+service);
		MyEmp emp = service.getEmp();
		model.addAttribute("emp", emp);
		return "success";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp(Model model) {
		System.out.println("service"+service);
		MyEmp emp = new MyEmp();
		emp.setEmpno(2112);
		emp.setEname("张三");
		int num = service.addEmp(emp);
		model.addAttribute("emp", num);
		return "success";
	}
}
