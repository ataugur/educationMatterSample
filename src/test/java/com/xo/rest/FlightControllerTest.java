package com.xo.rest;

import com.xo.model.dto.FlightDto;
import com.xo.model.entity.City;
import com.xo.model.entity.Flight;
import com.xo.service.FlightService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FlightControllerTest {
    private static final String SAMPLE_CITY_CODE_LA = "LA";
    private FlightService flightService = mock(FlightService.class);
    private FlightController flightController = new FlightController(flightService);

    @Test
    public void whenAddFlightThenReturnAddedFlight() {
        //Arrange
        final City city = mock(City.class);
        final Flight flight = new Flight();
        flight.setFrom(city);
        flight.setTo(city);
        when(flightService.addFlight(any())).thenReturn(flight);
        FlightDto flightDto = new FlightDto(flight);

        //Act
        FlightDto result = flightController.addFlight(flightDto);

        //Assert
        verify(flightService).addFlight(any());
        assertNotNull(result);
    }

    @Test
    public void whenListFlightsThenReturnFlightList() {
        //Arrange
        final City city = mock(City.class);
        Flight flight = new Flight();
        flight.setFrom(city);
        flight.setTo(city);
        final List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);
        when(flightService.listFlights(anyString(), anyString(), any(Date.class))).thenReturn(flightList);

        //Act
        List<FlightDto> result = flightController.listFlights(SAMPLE_CITY_CODE_LA, SAMPLE_CITY_CODE_LA, new Date());

        //Assert
        verify(flightService).listFlights(anyString(), anyString(), any(Date.class));
        assertThat(result.size(), is(1));
    }
}