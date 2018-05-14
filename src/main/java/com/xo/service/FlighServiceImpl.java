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

    FlighServiceImpl(CityService cityService, FlightRepository flightRepository) {
        this.cityService = cityService;
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(FlightDto flightDto) {
        log.debug("Adding flight: {}", flightDto);
        if (flightDto.getFromCityCode().equals(flightDto.getToCityCode())) {
            throw new FlightException("Flight cities can not be same");
        }
        City fromCity = cityService.getCity(flightDto.getFromCityCode());
        City toCity = cityService.getCity(flightDto.getToCityCode());
        Flight flight = new Flight(fromCity, toCity, flightDto.getFlightNo(), flightDto.getFlightDate());
        return flightRepository.save(flight);
    }
    
    
     @Override
     public List<Flight> listFlights(String fromCityCode, String toCityCode, Date date) {
         log.debug("Listing flights from {}, to city {}, date {}", fromCityCode, toCityCode, date);
         City fromCity = cityService.getCity(fromCityCode);
         City toCity = cityService.getCity(toCityCode);
         return flightRepository.findByFromAndToAndDate(fromCity, toCity, date);
     }
}
