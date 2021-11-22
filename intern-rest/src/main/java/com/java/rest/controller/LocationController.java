package com.java.rest.controller;


import com.java.rest.model.Location;

import com.java.rest.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping()
    public List<Location> getAllLocations(){
        return locationService.getAllLocation();
    }

    @PostMapping("/create")
    public void createLocation(@Valid @RequestBody Location location) {
        locationService.addLocation(location);
    }

    @GetMapping("{id}")
    public Optional<Location> getLocationById(@PathVariable  Integer id){
        return locationService.getLocationById(id);
    }

    @PutMapping("/update/{id}")
    public void updateLocation(@Valid @RequestBody Location location) {
        locationService.updateLocation(location);
    }

    @DeleteMapping("delete/{id}")
    public void deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
    }
}
