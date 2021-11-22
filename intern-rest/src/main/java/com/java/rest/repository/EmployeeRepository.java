package com.java.rest.repository;

import com.java.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(Integer id);

    List<Employee> findByLocation(Integer id);
}
