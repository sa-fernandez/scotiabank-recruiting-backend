package com.scotiabank.payroll.service.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotiabank.payroll.model.City;
import com.scotiabank.payroll.repository.CityRepository;
import com.scotiabank.payroll.request.CityRequest;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City createCity(CityRequest cityRequest) {
        if (cityRequest.getName() == null || cityRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("City name must not be empty");
        }

        City newCity = new City(cityRequest.getName());

        return this.cityRepository.save(newCity);
    }

    @Override
    public City getCityById(Long id) {
        if (!this.cityRepository.existsById(id)) {
            return null;
        }
        return this.cityRepository.findById(id).get();
    }

    @Override
    public List<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public City updateCity(Long id, CityRequest cityRequest) {
        if (!this.cityRepository.existsById(id)) {
            return null;
        }

        if (cityRequest.getName() == null || cityRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("City name must not be empty");
        }

        City uCity = this.cityRepository.findById(id).get();
        uCity.setName(cityRequest.getName());
        return this.cityRepository.save(uCity);
    }

    @Override
    public boolean deleteCity(Long id) {
        if (!this.cityRepository.existsById(id)) {
            return false;
        }
        this.cityRepository.deleteById(id);
        return true;
    }
    
}
