package com.company.service;

import com.company.client.DepartmentClient;
import com.company.dto.Department;
import com.company.dto.Location;
import com.company.exception.EmployeeNotFoundException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentClient departmentClient;
//    public Page<Department> listAll(int pageNum) {
//        int pageSize = 5;
//
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
//
//        return (Page<Department>) departmentClient.findAll(pageable);
//    }



    public Department get(Integer id) {
//        Department result = departmentClient.findById(id);
        Department result = departmentClient.findById(id);
        return result;

    }

    public List<Department> getAll(){
        List<Department> result = Collections.singletonList(departmentClient.findAll());
        return result;
    }


}
