package com.java.rest.controller;

import com.java.rest.model.Department;
import com.java.rest.model.Location;
import com.java.rest.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/department")
public class DepartmentController  {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/create")
    public void createDepartment(@Valid @RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @GetMapping("{id}")
    public Optional<Department> getDepartmentById(@PathVariable  Integer id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public void updateDepartment(@Valid @RequestBody Department department) {
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
    }
}
