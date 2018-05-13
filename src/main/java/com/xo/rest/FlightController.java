package com.xo.rest;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.xo.model.dto.FlightDto;

@RestController
public class FlightController {

    public FlightDto addFlight(FlightDto flightDto) {
        // TODO
        return null;
    }

    public List<FlightDto> listFlights(String fromCityCode, String toCityCode, Date date) {
        // TODO
        return null;
    }
}
