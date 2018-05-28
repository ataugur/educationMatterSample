package com.xo.service;

import java.util.Date;
import java.util.List;

import com.xo.exception.FlightException;
import com.xo.model.entity.City;
import com.xo.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.xo.model.dto.FlightDto;
import com.xo.model.entity.Flight;

@Slf4j
@Service
class FlighServiceImpl implements FlightService {
    private CityService cityService;
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(FlightDto flightDto) {
        return null;
    }
    
    
     @Override
     public List<Flight> listFlights(String fromCityCode, String toCityCode, Date date) {
        return null;
     }
}
