package com.java.rest.service;

import com.java.rest.model.Employee;
import com.java.rest.repository.EmployeeRepository;
import com.java.rest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeeByDepartment(Integer id) {
        return employeeRepository.findByDepartment(id);
    }

    public List<Employee> getEmployeeByLocation(Integer id) {
        return employeeRepository.findByLocation(id);
    }
}
