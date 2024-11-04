package com.scotiabank.payroll.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.payroll.model.City;
import com.scotiabank.payroll.request.CityRequest;
import com.scotiabank.payroll.service.city.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> createCity(@RequestBody CityRequest cityRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            City newCity = this.cityService.createCity(cityRequest);
            response.put("success", true);
            response.put("message", newCity);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCityById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        City city = this.cityService.getCityById(id);
        if (city != null) {
            response.put("success", true);
            response.put("message", city);
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to retrieve city by id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/cities")
    public ResponseEntity<?> getAllCities() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", this.cityService.getAllCities());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<?> updateCity(@PathVariable("id") Long id, @RequestBody CityRequest cityRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            City uCity = this.cityService.updateCity(id, cityRequest);
            if (uCity != null) {
                response.put("status", true);
                response.put("message", uCity);
                return ResponseEntity.ok().body(response);
            }
            response.put("success", false);
            response.put("message", "City not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        boolean isDeleted = this.cityService.deleteCity(id);

        if (isDeleted) {
            response.put("success", true);
            response.put("message", "City deleted successfully");
            return ResponseEntity.ok().body(response);
        }

        response.put("success", false);
        response.put("message", "City not found with id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
}
