package com.company.client;

import com.company.dto.Employee;
import com.company.dto.Location;

import org.modelmapper.internal.util.Assert;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LocationClient {
    public Location findById(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/location";
        ResponseEntity<Location> response
                = restTemplate.getForEntity(fooResourceUrl + "/"+id, Location.class);

        return response.getBody();
    }
    public void delete(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/location/delete";
        String entityUrl = fooResourceUrl + "/" + id;
        restTemplate.delete(entityUrl);
    }
    public void save(Location location) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/location/create";
        HttpEntity<Location> request = new HttpEntity<>(location);
        restTemplate.postForEntity(fooResourceUrl, request, Location.class);


    }

    public List<Location> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Location> entity = new HttpEntity<Location>(headers);
        ResponseEntity<List<Location>> response = restTemplate.exchange("http://localhost:8080/location",
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<Location>>() {});
        return response.getBody();
    }
}
