package com.java.rest.service;

import com.java.rest.model.Department;
import com.java.rest.model.Location;
import com.java.rest.repository.DepartmentRepository;
import com.java.rest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> getAllDepartment() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id){
        return departmentRepository.findById(id);
    }

    public void addDepartment(Department department){
        departmentRepository.save(department);
    }

    public void updateDepartment(Department department){
        departmentRepository.save(department);
    }

    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }
}
