package com.scotiabank.payroll.service.position;

import java.util.List;

import com.scotiabank.payroll.model.Position;
import com.scotiabank.payroll.request.PositionRequest;

public interface PositionService {

    public Position createPosition(PositionRequest positionRequest);
    public Position getPositionById(Long id);
    public List<Position> getAllPositions();
    public Position updatePosition(Long id, PositionRequest positionRequest);
    public boolean deletePosition(Long id);

}