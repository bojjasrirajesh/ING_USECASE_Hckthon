package com.ing.test.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.ing.test.employeemanagement.dto.RequestDTO;
import com.ing.test.employeemanagement.dto.ResponseDTO;
import com.ing.test.employeemanagement.entity.Employee;


public interface EmployeeService{

	ResponseDTO saveEmployees(RequestDTO employee);

	Iterable<Employee> getEmployee();

	Optional<Employee> getEmployeeById(int empId);

	ResponseDTO updateEmployeeById(RequestDTO employee,int empId);

	String deleteEmployee();

	String deleteEmployeeById(int empId);
	
	Optional<Employee> findByEmpNameAndAddress(String empName,String address);
	
	List<Employee> findByEmpNameEndsWith(String empName);
	
	List<Employee> findByEmpNameStartWith(String chars);
	
	List<Employee> findByEmpNameAndSalary(String empName,double salary);

}
