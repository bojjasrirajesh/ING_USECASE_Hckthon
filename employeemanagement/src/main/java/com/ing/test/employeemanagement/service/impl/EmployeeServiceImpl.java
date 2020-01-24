package com.ing.test.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.test.employeemanagement.dao.EmployeeDao;
import com.ing.test.employeemanagement.dto.RequestDTO;
import com.ing.test.employeemanagement.dto.ResponseDTO;
import com.ing.test.employeemanagement.entity.Employee;
import com.ing.test.employeemanagement.exception.ResourceNotFoundException;
import com.ing.test.employeemanagement.exception.UnabletoUpdateEmployeeException;
import com.ing.test.employeemanagement.service.EmployeeService;
import com.ing.test.employeemanagement.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	
	@Override
	public ResponseDTO saveEmployees(RequestDTO employee) {
		Employee employee2=new Employee();
		BeanUtils.copyProperties(employee, employee2);
		employeeDao.save(employee2);
		ResponseDTO  responseDTO=new ResponseDTO();
		responseDTO.setMessage(EmployeeUtil.SAVE_SUCCESSFULL);
		responseDTO.setStatusCode(HttpStatus.ACCEPTED.toString());
		return responseDTO;
	}


	@Override
	public Iterable<Employee> getEmployee() {
		
		return employeeDao.findAll();
	}


	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		Optional<Employee> employee = employeeDao.findById(empId);
		if(!employee.isPresent()) {
			throw new ResourceNotFoundException(EmployeeUtil.PROVIDE_EMPLOYEE_ID+ empId);
		}
		return employee;
	}


	@Override
	public ResponseDTO updateEmployeeById(RequestDTO employee,int empId) {
		
		ResponseDTO responseDTO=new ResponseDTO();
		if(employee.equals(null)||employee.toString().isEmpty()||empId==0) {
			throw new UnabletoUpdateEmployeeException(EmployeeUtil.EMPLOYEE_ID_NOTNULL);
		}else {
		Employee employee2=new Employee();
		employee2.setEmpId(empId);
			/*
			 * employee2.setEmpId(empId); employee2.setEmpName(employee.getEmpName());
			 * employee2.setSalary(employee.getSalary());
			 * employee2.setAddress(employee.getAddress());
			 */
		BeanUtils.copyProperties(employee, employee2);
		employeeDao.save(employee2);
		
		responseDTO.setMessage(EmployeeUtil.UDPATED_SUCCESSFULLY);
		responseDTO.setStatusCode(HttpStatus.ACCEPTED.toString());
		}
		return responseDTO;
	}


	@Override
	public String deleteEmployee() {
		employeeDao.deleteAll();
		return "deleted successfully";
	}


	@Override
	public String deleteEmployeeById(int empId) {
		employeeDao.deleteById(empId);
		return empId+" Deleted successfully";
	}


	@Override
	public Optional<Employee> findByEmpNameAndAddress(String empName, String address) {
		employeeDao.findByEmpNameAndAddress(empName,address);
		
		return employeeDao.findByEmpNameAndAddress(empName,address);
	}


	@Override
	public List<Employee> findByEmpNameEndsWith(String empName) {
		return employeeDao.findByEmpNameEndsWith(empName);
	}
	
	@Override
	public List<Employee> findByEmpNameStartWith(String empName) {
		return employeeDao.findByEmpNameStartWith(empName);
	}
	
	@Override
	public List<Employee> findByEmpNameAndSalary(String empName,double salary) {
		return employeeDao.findByEmpNameAndSalary(empName,salary);
	}

}
