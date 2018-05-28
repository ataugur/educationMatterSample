package com.xo.repository;

import com.xo.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xo.model.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}
