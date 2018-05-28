package com.xo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xo.model.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
