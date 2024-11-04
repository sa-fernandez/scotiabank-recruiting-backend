package com.scotiabank.payroll.service.position;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotiabank.payroll.model.Position;
import com.scotiabank.payroll.repository.PositionRepository;
import com.scotiabank.payroll.request.PositionRequest;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position createPosition(PositionRequest positionRequest) {
        if (positionRequest.getTitle() == null || positionRequest.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Position title must not be empty");
        }

        if (positionRequest.getSalary() == null || positionRequest.getSalary().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Position salary must be a positive value");
        }

        Position newPosition = new Position(positionRequest.getTitle(), positionRequest.getSalary());

        return this.positionRepository.save(newPosition);
    }

    @Override
    public Position getPositionById(Long id) {
        if (!this.positionRepository.existsById(id)) {
            return null;
        }
        return this.positionRepository.findById(id).get();
    }

    @Override
    public List<Position> getAllPositions() {
        return this.positionRepository.findAll();
    }

    @Override
    public Position updatePosition(Long id, PositionRequest positionRequest) {
        if (!this.positionRepository.existsById(id)) {
            return null;
        }

        if (positionRequest.getTitle() == null || positionRequest.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Position title must not be empty");
        }

        if (positionRequest.getSalary() == null || positionRequest.getSalary().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Position salary must be a positive value");
        }

        Position uPosition = this.positionRepository.findById(id).get();
        uPosition.setTitle(positionRequest.getTitle());
        uPosition.setSalary(positionRequest.getSalary());
        return this.positionRepository.save(uPosition);
    }

    @Override
    public boolean deletePosition(Long id) {
        if (!this.positionRepository.existsById(id)) {
            return false;
        }
        this.positionRepository.deleteById(id);
        return true;
    }

}
