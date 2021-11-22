package com.company.controller;

import com.company.client.LocationClient;
import com.company.dto.Employee;
import com.company.exception.EmployeeNotFoundException;
import com.company.dto.Location;
import com.company.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationClient locationClient;
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String showLocationList(Model model) {

        List<Location> locations = locationClient.getAll();
        model.addAttribute("listLocation", locations);
        return "locations";
    }
    @RequestMapping("/location/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {


//        Page<Location> page = service.listAll(pageNum);
//        List<Location> listLocations = page.getContent();
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("currentPage", pageNum);
//        model.addAttribute("listLocation", listLocations);
        return "locations";
    }


    @GetMapping("/location/new")
    public String showNewForm(@Valid Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("pageTitle", "Add New Location");
        return "location_form";
    }

    @PostMapping("/location/save")
    public String saveLocation( Location location, RedirectAttributes ra) {
        locationClient.save(location);
        ra.addFlashAttribute("message", "The Location has been saved successfully");
        return "redirect:/locations";
    }

    @GetMapping("/location/edit/{id}")
    public String showEditForm(@Valid @PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        Location location = locationService.get(id);
        model.addAttribute("location", location);
        model.addAttribute("pageTitle", "Edit Location (ID: " + id +")");
        return "location_form";
    }

    @GetMapping("/location/delete/{id}")
    public String deleteLocation(@PathVariable("id") Integer id, RedirectAttributes ra){
        locationClient.delete(id);
        ra.addFlashAttribute("message", "The Location ID "+ id + " has been deleted");
        return "redirect:/locations";
    }
}

