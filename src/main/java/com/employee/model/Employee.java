package com.employee.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String empname;
	private String phone;
	private String address;
	private int age;
	private String designation;
	private String username;
	private String password;

	@Temporal(TemporalType.DATE)
	private Date created;
	@Temporal(TemporalType.DATE)
	private Date modified;

	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Employee(int id, String empname, String phone, String address, int age, String designation, String username,
			String password, Date created, Date modified, int status) {
		super();
		this.id = id;
		this.empname = empname;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.designation = designation;
		this.username = username;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.status = status;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", phone=" + phone + ", address=" + address + ", age="
				+ age + ", designation=" + designation + ", username=" + username + ", password=" + password
				+ ", created=" + created + ", modified=" + modified + ", status=" + status + "]";
	}


}
