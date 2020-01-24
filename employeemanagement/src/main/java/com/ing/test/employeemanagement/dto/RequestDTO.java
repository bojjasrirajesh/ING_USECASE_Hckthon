package com.ing.test.employeemanagement.dto;

import java.io.Serializable;

public class RequestDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	
	private String empName;
	private double salary;
	private String address;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
