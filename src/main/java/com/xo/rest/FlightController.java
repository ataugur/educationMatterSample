package com.xo.rest;

import com.xo.model.dto.FlightDto;
import com.xo.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
class FlightController {
    private static final String FLIGHT_ENDPOINT = "/flights";

    private FlightService flightService;

    @PostMapping(FLIGHT_ENDPOINT)
    public FlightDto addFlight(FlightDto flightDto) {
        return null;
    }

    @GetMapping(FLIGHT_ENDPOINT)
    public List<FlightDto> listFlights(String fromCityCode, String toCityCode, Date date) {
       return null;
    }
}
