package com.company.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
public class Employee {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private Location location;
    private Department department;



}
