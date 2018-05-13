package com.xo.service;

import java.util.Date;
import java.util.List;

import com.xo.model.dto.FlightDto;
import com.xo.model.entity.Flight;

public interface FlightService {

    Flight addFlight(FlightDto flightDto);

    List<Flight> listFlights(String fromCityCode, String toCityCode, Date date);

}
