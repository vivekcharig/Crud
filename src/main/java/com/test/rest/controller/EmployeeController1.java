package com.test.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.dao.EmployeeDao;
import com.test.rest.model.Employee;
import com.test.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeDao repo;

	@RequestMapping(value = "/all")
	public ResponseEntity<List<Employee>> listEmployee() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee employee) {
		if (employee.getId() == 0) {
			employeeService.saveEmployee(employee);
		}
		return "SAVED SUCCESSFULLY";

	}

	@GetMapping("/customerByid/{id}")
	public ResponseEntity<Employee> getcById(@PathVariable int id) {
		if (repo.findById(id).isPresent()) {
			return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		repo.deleteById(id);

	}
}
