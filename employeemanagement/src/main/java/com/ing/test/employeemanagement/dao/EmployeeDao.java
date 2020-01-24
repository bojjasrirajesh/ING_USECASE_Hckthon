package com.ing.test.employeemanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ing.test.employeemanagement.entity.Employee;
@Repository
public interface  EmployeeDao extends CrudRepository<Employee, Integer> {

	Optional<Employee> findByEmpNameAndAddress(String empName,String address);
	
	@Query("select e from Employee e where e.empName like %?1")
	List<Employee> findByEmpNameEndsWith(String chars);

	@Query("select e from Employee e where e.empName like ?1%")
	List<Employee> findByEmpNameStartWith(String chars);
	
	@Query("select e from Employee e where e.empName=?1 OR e.salary>=?2")
	List<Employee> findByEmpNameAndSalary(String empName,double salary);
}
