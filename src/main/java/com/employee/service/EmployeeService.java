package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	
	public List<Employee> empList();
	public String saveEmp(Employee emp);
	public Employee findEmployeeById(int empId);
	public String updateEmp(int empId,Employee emp);
	public String deleteEmp(int empId);
	public Employee findEmployeeByUsernameAndPassword(String username, String password);
	public Employee findEmployeeByUsername(String username);

}
