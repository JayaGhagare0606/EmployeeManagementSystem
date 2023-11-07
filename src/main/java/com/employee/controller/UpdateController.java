package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;

@Controller
public class UpdateController {
	@Autowired
	EmployeeServiceImpl empservice;
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")int id, Model m) {
		
		Employee empbyId = empservice.findEmployeeById(id);
		
		m.addAttribute("emp",empbyId);
		
		return "update.html";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id") int empId, Model m) {
		empservice.deleteEmp(empId);
		
		m.addAttribute("empList",empservice.empList());
		return "empList.html";
	}
	
	@PostMapping("/updateEmp/{id}")
	public String UpdateEmp(@PathVariable("id") int id, Model m, @ModelAttribute("employee") Employee emp ) {
		Employee empbyId = empservice.findEmployeeById(id);
		System.out.println("Employee=> "+emp);
		
		String empname = emp.getEmpname();
		int age = emp.getAge();
		String address = emp.getAddress();
		String phone = emp.getPhone();
		String designation = emp.getDesignation();
		String username = emp.getUsername();
		String password = emp.getPassword();
		
		if(empname.isEmpty())
		{
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee name is mandatory");
			return "update.html";
		}
		if(age == 0) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee age is mandatory");
			return "update.html";
		}
		if(address.isEmpty()) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee address is mandatory");
			return "update.html";
		}
		if(phone.isEmpty()) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee phone is mandatory");
			return "update.html";
		}
		if(designation.isEmpty()) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee designation is mandatory");
			return "update.html";
		}
		if(username.isEmpty()) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee username is mandatory");
			return "update.html";
		}
		if(password.isEmpty()) {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "employee password is mandatory");
			return "update.html";
		}
		String updateEmp = empservice.updateEmp(id, emp);
		if(updateEmp != "Employee Updated.") {
			m.addAttribute("emp", empbyId);
			m.addAttribute("error", "Something Went Wrong");
			return "update.html";
		}
		else {
			m.addAttribute("empList",empservice.empList());
			return "empList.html";
		}
	}

}
