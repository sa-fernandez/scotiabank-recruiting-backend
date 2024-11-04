package com.scotiabank.payroll.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.payroll.model.Position;
import com.scotiabank.payroll.request.PositionRequest;
import com.scotiabank.payroll.service.position.PositionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> createPosition(@RequestBody PositionRequest positionRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            Position newPosition = this.positionService.createPosition(positionRequest);
            response.put("success", true);
            response.put("message", newPosition);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPositionById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Position city = this.positionService.getPositionById(id);
        if (city != null) {
            response.put("success", true);
            response.put("message", city);
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to retrieve city by id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/positions")
    public ResponseEntity<?> getAllPositions() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", this.positionService.getAllPositions());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<?> updatePosition(@PathVariable("id") Long id, @RequestBody PositionRequest positionRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            Position uPosition = this.positionService.updatePosition(id, positionRequest);
            if (uPosition != null) {
                response.put("status", true);
                response.put("message", uPosition);
                return ResponseEntity.ok().body(response);
            }
            response.put("success", false);
            response.put("message", "Position not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        boolean isDeleted = this.positionService.deletePosition(id);

        if (isDeleted) {
            response.put("success", true);
            response.put("message", "Position deleted successfully");
            return ResponseEntity.ok().body(response);
        }

        response.put("success", false);
        response.put("message", "Position not found with id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
}
