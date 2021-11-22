package com.java.rest.repository;

import com.java.rest.model.Employee;
import com.java.rest.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
