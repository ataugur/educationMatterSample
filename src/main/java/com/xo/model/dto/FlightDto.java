package com.xo.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class FlightDto {
     private String fromCityCode;
     private String toCityCode;
     private String flightNo;
     private Date flightDate;
}
