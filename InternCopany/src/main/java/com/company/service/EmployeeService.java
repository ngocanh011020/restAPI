package com.company.service;

import com.company.client.EmployeeClient;


import com.company.dto.Department;
import com.company.dto.Employee;
import com.company.dto.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeClient employeeClient;

//    public Page<Employee> listAll(int pageNum) {
//        int pageSize = 5;
//        return (Page<Employee>) employeeClient.getAll(pageNum, pageSize);
//    }


    public Employee get(Integer id) {
        Employee result = employeeClient.findById(id);
        return result;
    }

}
