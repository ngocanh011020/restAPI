package com.company.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Department {
    private Integer id;
    private String departmentName;
    private String description;
    private boolean enabled;
}
