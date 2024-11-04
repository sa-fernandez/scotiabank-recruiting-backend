package com.scotiabank.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scotiabank.payroll.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    
}
