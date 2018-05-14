package com.xo.service;

import com.xo.exception.FlightException;
import com.xo.model.dto.FlightDto;
import com.xo.model.entity.City;
import com.xo.model.entity.Flight;
import com.xo.repository.FlightRepository;
import org.assertj.core.util.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FlightServiceImplTest {
    private static final String SAMPLE_CITY_CODE_LA = "LA";
    private static final String SAMPLE_CITY_CODE_NY = "NY";
    private static final String SAMPLE_FLIGHT_NO = "F15";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CityService cityService = mock(CityService.class);
    private FlightRepository flightRepository = mock(FlightRepository.class);
    private FlighServiceImpl flightService = new FlighServiceImpl(cityService, flightRepository);

    @Test
    public void whenAddFlightThenReturnAddedFlight() {
        //Arrange
        final City city = new City();
        when(cityService.getCity(anyString())).thenReturn(city);
        Flight flight = new Flight();
        flight.setFrom(city);
        when(flightRepository.save(any())).thenReturn(flight);
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightNo(SAMPLE_FLIGHT_NO);
        flightDto.setFromCityCode(SAMPLE_CITY_CODE_LA);
        flightDto.setToCityCode(SAMPLE_CITY_CODE_NY);
        flightDto.setFlightDate(new Date());

        //Act
        Flight result = flightService.addFlight(flightDto);

        //Assert
        verify(cityService, times(2)).getCity(anyString());
        assertThat(result.getFrom(), is(city));
    }

    @Test
    public void givenWrongCityCodeWhenGetCityThenThrowException() {
        //Arrange
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightNo(SAMPLE_FLIGHT_NO);
        flightDto.setFromCityCode(SAMPLE_CITY_CODE_LA);
        flightDto.setToCityCode(SAMPLE_CITY_CODE_LA);
        flightDto.setFlightDate(new Date());
        expectedException.expect(FlightException.class);

        //Act
        flightService.addFlight(flightDto);
    }

    @Test
    public void whenListFlightsThenReturnFlightList() {
        //Arrange
        final City city = new City();
        when(cityService.getCity(anyString())).thenReturn(city);
        when(flightRepository.findByFromAndToAndDate(eq(city), eq(city), any(Date.class))).thenReturn(Lists.emptyList());


        //Act
        List<Flight> result = flightService.listFlights(SAMPLE_CITY_CODE_LA, SAMPLE_CITY_CODE_NY, new Date());

        //Assert
        verify(cityService, times(2)).getCity(anyString());
        assertThat(result, is(Lists.emptyList()));
    }
}
