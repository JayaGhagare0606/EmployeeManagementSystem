package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;

@Controller
public class ForgotPasswordController {

	@Autowired
	EmployeeServiceImpl employeeservice;

	public static Employee employee;

	@GetMapping("/forgotpass")
	public String forgot() {
		return "forgotpassword.html";
	}

	@PostMapping("/forgotpass")
	public String forgotpassword(@ModelAttribute("employee") Employee emp, Model m) {
		String username = emp.getUsername();
		if (username.isEmpty()) {
			m.addAttribute("error", "Username Is required.");
			return "forgotpassword.html";
		}
		employee = employeeservice.findEmployeeByUsername(username);
		System.out.println(employee);
		if (employee == null) {
			m.addAttribute("error", "Username is not created yet. Please Signup.");
			return "forgotpassword.html";
		} else {
			m.addAttribute("username", username);
			return "setpassword.html";
		}
	}

	@PostMapping("/setPassword")
	public String SetPassword(@ModelAttribute("employee") Employee emp, Model m) {
		String password = emp.getPassword();
		if (password.isEmpty()) {
			m.addAttribute("error", "Password Is required.");
			m.addAttribute("username", employee.getUsername());
			return "forgotpassword.html";
		}
		employee.setPassword(password);
		String updateEmployee = employeeservice.updateEmp(employee.getId(), employee);
		if (updateEmployee == "Employee Updated.") {
			m.addAttribute("success", "Password Updated.");
			return "setpassword.html";
		} else {
			m.addAttribute("error", "Something Went Wrong");
			return "setpassword.html";
		}
	}

}
