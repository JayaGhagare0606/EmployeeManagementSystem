package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;

@Controller
public class LoginController {
	@GetMapping("/")
	public String GetList() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("employee") Employee employee, Model model) {
		String username = employee.getUsername();
		String password = employee.getPassword();
		
		if(username.isEmpty()) {
			model.addAttribute("error", "Username is required.");
			model.addAttribute(employee);
			return "login.html";
		}
		if(password.isEmpty()) {
			model.addAttribute("error", "Password is required.");
			return "login.html";
		}
		return "landing.html";
	}

}
