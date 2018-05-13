package com.xo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xo.model.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
