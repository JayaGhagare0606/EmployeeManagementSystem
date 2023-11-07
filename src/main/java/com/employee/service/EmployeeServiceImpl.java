package com.employee.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl extends HomeService implements EmployeeService{

	@Override
	public List<Employee> empList() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public String saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		Employee save = empRepo.save(emp);
		if(save == null) {
			return null;
		}
		return "save";
	}

	@Override
	public Employee findEmployeeById(int empId) {
		// Find Employee By Id => it will provide single employee object
		
		List<Employee> empList = empList();
		Employee employee = null;
		
		for(Employee emp : empList) {
			if(emp.getId() == empId) {
				employee = emp;
			}
		}
		
		
		return employee;
	}

	@Override
	public String updateEmp(int empId, Employee emp) {
		// TODO Auto-generated method stub
		Employee oldEmployee = findEmployeeById(empId);
		oldEmployee.setEmpname(emp.getEmpname());
		oldEmployee.setAge(emp.getAge());
		oldEmployee.setAddress(emp.getAddress());
		oldEmployee.setDesignation(emp.getDesignation());
		oldEmployee.setModified(new Date());
		oldEmployee.setPassword(emp.getPassword());
		oldEmployee.setPhone(emp.getPhone());
		oldEmployee.setStatus(emp.getStatus());
		empRepo.save(oldEmployee);
		return "Employee Updated.";
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		Employee oldEmployee = findEmployeeById(empId);
		empRepo.delete(oldEmployee);
		return "Employee deleted.";
	}

	@Override
	public Employee findEmployeeByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeByUsernameAndPassword(username, password);
	}

	@Override
	public Employee findEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeByUsername(username);
	}

}
