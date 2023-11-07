package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.employee.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empserv;
	
	@GetMapping("/emp")
	public String getEmp(Model m) {
		m.addAttribute("empList", empserv.empList());
		return "empList.html";
	}
	
}
