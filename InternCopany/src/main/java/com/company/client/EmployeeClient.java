package com.company.client;

import com.company.dto.Employee;

import com.company.dto.Location;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;


@Service
public class EmployeeClient {
    public Employee findById(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/employee";
        ResponseEntity<Employee> response
                = restTemplate.getForEntity(fooResourceUrl + "/"+id, Employee.class);

        return response.getBody();
    }

    public List<Employee> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
        ResponseEntity<List<Employee>> response = restTemplate.exchange("http://localhost:8080/employee",
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<Employee>>() {});
        return response.getBody();
    }

    public void delete(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/employee/delete";
        String entityUrl = fooResourceUrl + "/" + id;
        restTemplate.delete(entityUrl);
    }

    public void save(Employee employee) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/employee/create";
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        restTemplate.postForEntity(fooResourceUrl, request, Employee.class);
    }



}
