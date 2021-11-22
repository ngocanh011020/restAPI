package com.java.rest;

import com.java.rest.model.Department;
import com.java.rest.model.Employee;
import com.java.rest.model.Location;
import com.java.rest.repository.DepartmentRepository;
import com.java.rest.repository.EmployeeRepository;
import com.java.rest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InternRestApplication.class, args);
    }
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {

        Location location = new Location();
        location.setPlace("Da Nang");
        location.setDescription("Tran Cao Van");
        location.setEnabled(true);
        locationRepository.save(location);

        Department department = new Department();
        department.setDepartmentName("IT");
        department.setDescription("Java");
        department.setEnabled(true);
        departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setFirstName("Pham");
        employee.setEmail("anh@gmail");
        employee.setLastName("Anh");
        employee.setLocation(location);
        employee.setDepartment(department);
        employee.setEnabled(true);
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Pham Ngoc");
        employee1.setEmail("a@gmail");
        employee1.setLastName("A");
        employee1.setLocation(location);
        employee1.setDepartment(department);
        employee1.setEnabled(true);
        employeeRepository.save(employee1);
    }

}
