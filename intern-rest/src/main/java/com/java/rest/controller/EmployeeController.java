package com.java.rest.controller;

import com.java.rest.model.Employee;

import com.java.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;




    @GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }


    @PostMapping("/create")
    public void createEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }


    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable  Integer id){
        return employeeService.getEmployeeById(id);
    }


    @PutMapping("/update/{id}")
    public void updateEmployee(@Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }


    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("location/{id}")
    public List<Employee> getEmployeeByLocation(@PathVariable Integer id){
        return employeeService.getEmployeeByLocation(id);
    }

    @GetMapping("department/{id}")
    public List<Employee> getEmployeeByDepartment(@PathVariable Integer id){
        return employeeService.getEmployeeByDepartment(id);
    }
}
