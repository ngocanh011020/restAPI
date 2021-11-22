package com.company.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class Location {

    private Integer id;
    private String place;
    private String description;
    private boolean enabled;


}
