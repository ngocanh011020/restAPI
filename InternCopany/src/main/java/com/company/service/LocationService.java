package com.company.service;

import com.company.client.LocationClient;
import com.company.dto.Location;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationClient locationClient;
//    public Page<Location> listAll(int pageNum) {
//        int pageSize = 5;
//
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
//
//        return repo.findAll(pageable);
//    }

    public Location get(Integer id) {
        Location result = locationClient.findById(id);
        return result;
    }






}
