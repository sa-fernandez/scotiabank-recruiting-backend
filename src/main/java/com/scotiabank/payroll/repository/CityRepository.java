package com.scotiabank.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scotiabank.payroll.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    
}
