package com.xo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xo.model.entity.City;
import com.xo.repository.CityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingApplicationIT {

    @Autowired
    private CityRepository cityRepository;
    
	@Test
	public void contextLoads() {
	    City city = new City();
	    city.setCode("16");
	    city.setName("Bursa");
	    
	    city=cityRepository.save(city);
	    cityRepository.flush();
	    System.out.println(city.getCreateDate());
	}

}
