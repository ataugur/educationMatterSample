package com.xo.service;

import com.xo.exception.CityNotFoundException;
import com.xo.model.entity.City;
import com.xo.repository.CityRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CityServiceImplTest {
    private static final String SAMPLE_CITY_CODE = "cityCode";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CityRepository cityRepository = mock(CityRepository.class);
    private CityServiceImpl cityService = new CityServiceImpl(cityRepository);

    @Test
    public void whenGetCityThenReturnCity() {
        //Arrange
        final City city = new City();
        when(cityRepository.findByCode(anyString())).thenReturn(city);

        //Act
        City result = cityService.getCity(SAMPLE_CITY_CODE);

        //Assert
        verify(cityRepository).findByCode(anyString());
        assertThat(result, is(city));
    }

    @Test
    public void givenWrongCityCodewhenGetCityThenThrowException() {
        //Arrange
        when(cityRepository.findByCode(anyString())).thenReturn(null);
        expectedException.expect(CityNotFoundException.class);

        //Act
        cityService.getCity(SAMPLE_CITY_CODE);
    }
}
