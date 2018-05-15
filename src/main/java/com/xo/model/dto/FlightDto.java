package com.xo.model.dto;

import com.xo.model.entity.Flight;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FlightDto {
    private String fromCityCode;
    private String toCityCode;
    private String flightNo;
    private Date flightDate;
    public FlightDto(Flight flight) {
        this.fromCityCode = flight.getFrom().getCode();
        this.toCityCode = flight.getTo().getCode();
        this.flightNo = flight.getFlightNo();
        this.flightDate = flight.getDate();
    }
}
