package com.employee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;

@Controller
public class RegistrationController {

	@Autowired
	EmployeeServiceImpl employeeService;
	
	@GetMapping("/signup")
	public String register(Model m) {
		m.addAttribute("age", "0");
		return "home.html";
	}

	@PostMapping("/register")
	public String saveEmployee(@ModelAttribute("employee") Employee emp, Model m) {
		String empname = emp.getEmpname();
		int age = emp.getAge();
		String address = emp.getAddress();
		String designation = emp.getDesignation();
		String password = emp.getPassword();
		String phone = emp.getPhone();
		String username = emp.getUsername();
		System.out.println("Age"+age);
		if(empname.isEmpty()) {
			m.addAttribute("error", "Name is required.");
			m.addAttribute("age", "0");
			return "home.html";
		}
		if(phone.isEmpty()) {
			m.addAttribute("error", "Contact Number is Required.");
			m.addAttribute("name", empname);
			m.addAttribute("age", "0");
			return "home.html";
		}

		if (age == 0) {
			m.addAttribute("error", "Age is required.");
			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			return "home.html";
		}
		if (designation.isEmpty()) {
			m.addAttribute("error", "Designation is required.");
			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			m.addAttribute("age", age);

			return "home.html";
		}
		if (address.isEmpty()) {
			m.addAttribute("error", "Address is required.");
			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			m.addAttribute("age", age);
			m.addAttribute("designation", designation);
			return "home.html";
		}

		if (username.isEmpty()) {
			m.addAttribute("error", "Username is required.");
			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			m.addAttribute("age", age);
			m.addAttribute("designation", designation);
			m.addAttribute("address", address);

			return "home.html";
		}
		if (password.isEmpty()) {
			m.addAttribute("error", "Password is required.");
			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			m.addAttribute("age", age);
			m.addAttribute("address", address);
			m.addAttribute("designation", designation);
			m.addAttribute("username", username);
			return "home.html";
		}

		Employee findUsername = employeeService.findEmployeeByUsername(username);

		if (findUsername != null) {
			m.addAttribute("error", "Username already taken.\n try again with new  username.");

			m.addAttribute("name", empname);
			m.addAttribute("number", phone);
			m.addAttribute("age", age);
			m.addAttribute("address", address);
			m.addAttribute("designation", designation);
			m.addAttribute("username", username);
			m.addAttribute("password",password);
			return "home.html";
			
		}else {
			emp.setCreated(new Date());
			emp.setModified(new Date());
			emp.setStatus(1);
			
			employeeService.saveEmp(emp);
			m.addAttribute("success", "User created sucessfully...");
				return "login.html";
		}
	}
}
