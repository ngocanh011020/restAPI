package com.company.controller;

import com.company.client.DepartmentClient;
import com.company.client.EmployeeClient;
import com.company.client.LocationClient;
import com.company.dto.Department;
import com.company.dto.Employee;
import com.company.dto.Location;
import com.company.service.DepartmentService;
import com.company.service.EmployeeService;
import com.company.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private DepartmentClient departmentClient;
    @Autowired
    private LocationClient locationClient;
    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping("/employees")
//    public String showEmployeeList(Model model) {
//        Employee employee = service.getAll();
//        model.addAttribute("listEmployee", employee);
//        return "employees";
//    }
    @GetMapping("/employees")
    public String showEmployeeList(Model model) {
        List<Employee> employees = employeeClient.getAll();
        model.addAttribute("listEmployee", employees);
        return "employees";
    }
    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {


//        Page<Employee> page = service.listAll(pageNum);
//        List<Employee> listEmployees = page.getContent();
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("listEmployee", listEmployees);
        return "employees";
    }

    @GetMapping("/employee/new")
    public String showNewForm(@Valid Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("pageTitle", "Add New Employee");
        List<Department> departments = departmentClient.getAll();
        model.addAttribute("department",departments);
        List<Location> locations = locationClient.getAll();
        model.addAttribute("location",locations);
        return "employee_form";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@Valid Employee employee, RedirectAttributes ra) {
        employeeClient.save(employee);
        ra.addFlashAttribute("message", "The Employee has been saved successfully");
        return "redirect:/employees";
    }

    @GetMapping("/employee/edit/{id}")
    public String showEditForm(@Valid @PathVariable("id") Integer id, Model model, RedirectAttributes ra){

            Employee employee = service.get(id);
            model.addAttribute("employee", employee);
            model.addAttribute("pageTitle", "Edit Employee (ID: " + id +")");
            List<Department> departments = departmentClient.getAll();
            model.addAttribute("department",departments);
            List<Location> locations = locationClient.getAll();
            model.addAttribute("location",locations);
            return "employee_form";

    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id, RedirectAttributes ra){
        employeeClient.delete(id);
        ra.addFlashAttribute("message", "The Employee ID "+ id + " has been deleted");
        return "redirect:/employees";
    }
}
