package com.ing.test.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.test.employeemanagement.dto.RequestDTO;
import com.ing.test.employeemanagement.dto.ResponseDTO;
import com.ing.test.employeemanagement.entity.Employee;
import com.ing.test.employeemanagement.service.EmployeeService;

/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 21-01-2020
 */

@RestController
public class EmployeeController {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * @param employee type 
	 * @return String of employee response 
	 */
	@PostMapping("/employees")
	public ResponseDTO saveEmployees(@RequestBody RequestDTO requestDTO) {
		LOGGER.info("saveEmployees Method in EmployeeController started");
		return employeeService.saveEmployees(requestDTO);
		
	}
	
	/**
	 * 
	 * @return List of employees 
	 */
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		LOGGER.info("getEmployees Method in EmployeeController started");
		return employeeService.getEmployee();
		
	}
	
	/**
	 * @param empId of employee 
	 * @return employee as response of empId 
	 */
	@GetMapping("/employees/{empId}")
	public Optional<Employee> getEmployeesById(@PathVariable int empId) {
		LOGGER.info("getEmployeesById Method in EmployeeController started");
		return employeeService.getEmployeeById(empId);
		
	}
	
	/**
	 * @param empId of employee 
	 * @param requestDTO
	 * @return ResponseDTO as response
	 */
	@PutMapping("/employees/{empId}")
	public ResponseDTO updateEmployeesById(@RequestBody RequestDTO requestDTO, @PathVariable int empId) {
		LOGGER.info("updateEmployeesById Method in EmployeeController started");
		return employeeService.updateEmployeeById(requestDTO,empId);
		
	}
	
	/**
	 * @return string as response
	 */
	@DeleteMapping("/employees")
	public String deleteEmployees() {
		LOGGER.info("deleteEmployees Method in EmployeeController started");
		return employeeService.deleteEmployee();
		
	}
	
	/**
	 * @param empId of employee 
	 * @return string as response
	 */
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployeesById(@PathVariable int empId) {
		
		LOGGER.info("deleteEmployeesById Method in EmployeeController started");
		return employeeService.deleteEmployeeById(empId);
		
	}
	
	/**
	 * @param empName of employee 
	 * @param address of employee
	 * @return employee as response
	 */
	@GetMapping("/employees/{empName}/{address}")
	public Optional<Employee> findByEmpNameAndAddress(@PathVariable String empName,@PathVariable String address) {
		
		LOGGER.info("findByEmpNameAndAddress Method in EmployeeController started");
		return employeeService.findByEmpNameAndAddress(empName, address);
		
	}
	
	/**
	 * @param empName of employee 
	 * @return employee as response
	 */
	@GetMapping("/employees/query/end")
	public List<Employee> getEmployeeEndsWith(@RequestParam String empName) {
		
		LOGGER.info("getEmployeeStartWith Method in EmployeeController started");
		return employeeService.findByEmpNameEndsWith(empName);
		
	}
	
	/**
	 * @param empName of employee 
	 * @return employee as response
	 */
	@GetMapping("/employees/query")
	public List<Employee> getEmployeeStartWith(@RequestParam String empName) {
		
		LOGGER.info("getEmployeeStartWith Method in EmployeeController started");
		return employeeService.findByEmpNameStartWith(empName);
		
	}
	
	/**
	 * @param empName of employee 
	 * @param salary of employee
	 * @return List of employee as response
	 */
	@GetMapping("/employees/empName/salary")
	public List<Employee> getByEmpNameAndSalary(@RequestParam String empName,@RequestParam double salary) {
		
		LOGGER.info("getByEmpNameAndSalary Method in EmployeeController started");
		return employeeService.findByEmpNameAndSalary(empName,salary);
		
	}
	

}
