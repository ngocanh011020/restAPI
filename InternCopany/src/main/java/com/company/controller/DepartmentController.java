package com.company.controller;

import com.company.client.DepartmentClient;
import com.company.dto.Location;
import com.company.exception.EmployeeNotFoundException;
import com.company.dto.Department;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @Autowired
    private DepartmentClient departmentClient;

    @GetMapping("/departments")
    public String showDepartmentList(Model model) {
        List<Department> departments = departmentClient.getAll();
        model.addAttribute("listDepartment", departments);
        return "departments";
    }
    @RequestMapping("/department/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {


//        Page<Department> page = service.listAll(pageNum);
//        List<Department> listDepartments = page.getContent();
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("listDepartment", listDepartments);
        return "departments";
    }

    @GetMapping("/department/new")
    public String showNewForm(@Valid Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("pageTitle", "Add New Department");
        return "department_form";
    }

    @PostMapping("/department/save")
    public String saveDepartment(@Valid Department department, RedirectAttributes ra) {
        departmentClient.save(department);
        ra.addFlashAttribute("message", "The Department has been saved successfully");
        return "redirect:/departments";
    }

    @GetMapping("/department/edit/{id}")
    public String showEditForm(@Valid @PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        Department department = service.get(id);
        model.addAttribute("department", department);
        model.addAttribute("pageTitle", "Edit Department (ID: " + id +")");
        return "department_form";
    }

    @GetMapping("/department/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id, RedirectAttributes ra){

            departmentClient.delete(id);
            ra.addFlashAttribute("message", "The Department ID "+ id + " has been deleted");
        return "redirect:/departments";
    }
}

