package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.repository.EmployeeRepository;

public class HomeService {
	
	@Autowired
	EmployeeRepository empRepo;
}
