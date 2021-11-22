package com.company.client;

import com.company.dto.Department;

import com.company.dto.Location;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentClient {
    public Department findById(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/department";
        ResponseEntity<Department> response
                = restTemplate.getForEntity(fooResourceUrl + "/"+id, Department.class);
        return response.getBody();
    }

    public Department findAll(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Department> response =restTemplate.getForEntity(
                "http://localhost:8080/department",
                Department.class);
        return response.getBody();
    }

    public List<Department> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Department> entity = new HttpEntity<Department>(headers);
        ResponseEntity<List<Department>> response = restTemplate.exchange("http://localhost:8080/department",
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<Department>>() {});
        return response.getBody();
    }

    public void delete(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/department/delete";
        String entityUrl = fooResourceUrl + "/" + id;
        restTemplate.delete(entityUrl);
    }

    public void save(Department department) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/department/create";
        HttpEntity<Department> request = new HttpEntity<>(department);
        restTemplate.postForEntity(fooResourceUrl, request, Department.class);
    }
}
