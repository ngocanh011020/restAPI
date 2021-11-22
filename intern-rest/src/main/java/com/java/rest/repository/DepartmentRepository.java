package com.java.rest.repository;

import com.java.rest.model.Department;
import com.java.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
