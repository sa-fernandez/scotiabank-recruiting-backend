package com.scotiabank.payroll.service.city;

import java.util.List;

import com.scotiabank.payroll.model.City;
import com.scotiabank.payroll.request.CityRequest;

public interface CityService {

    public City createCity(CityRequest cityRequest);
    public City getCityById(Long id);
    public List<City> getAllCities();
    public City updateCity(Long id, CityRequest cityRequest);
    public boolean deleteCity(Long id);
    
}
