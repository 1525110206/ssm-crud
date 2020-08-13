package com.javaweb.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaweb.crud.bean.Department;
import com.javaweb.crud.bean.Msg;
import com.javaweb.crud.service.DepartmentService;

/*
 * �����Ͳ����йص�����
 */

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		
		//��������в�����Ϣ
		List<Department> list = departmentService.getDepts();
		
		return Msg.success().add("depts", list);
	}
	
}