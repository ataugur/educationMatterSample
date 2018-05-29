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
}
