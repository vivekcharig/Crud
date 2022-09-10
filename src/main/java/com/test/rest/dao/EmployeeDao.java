package com.test.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rest.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
