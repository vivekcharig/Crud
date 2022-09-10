package com.test.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.dao.EmployeeDao;
import com.test.rest.model.Employee;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao repo;

	public Employee saveEmployee(Employee e) {
		System.out.println("service.....");
		return repo.save(e);

	}

	public Employee getEmployee(int empid) {
		return repo.getById(empid);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int employeeId) {
		repo.deleteById(employeeId);
		;
		return true;

	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return repo.findAll();

	}
}
