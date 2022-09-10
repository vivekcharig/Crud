package com.test.rest.service;

import java.util.List;

import com.test.rest.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee e);
	public Employee getEmployee(int employeeid);
	public boolean deleteEmployee(int employeeId);
	public List<Employee> getAllEmployees();
	

}
