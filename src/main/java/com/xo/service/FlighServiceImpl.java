package com.xo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xo.model.dto.FlightDto;
import com.xo.model.entity.Flight;

@Service
class FlighServiceImpl implements FlightService {

    @Override
    public Flight addFlight(FlightDto flightDto) {
        //TODO
        return null;
    }
    
    
     @Override
     public List<Flight> listFlights(String fromCityCode, String toCityCode, Date date) {
         //TODO
         return null;
     }
}
