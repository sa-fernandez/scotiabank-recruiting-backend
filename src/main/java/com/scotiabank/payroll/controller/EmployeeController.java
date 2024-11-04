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

import com.scotiabank.payroll.dto.EmployeeDetailsDTO;
import com.scotiabank.payroll.model.Employee;
import com.scotiabank.payroll.request.EmployeeRequest;
import com.scotiabank.payroll.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            Employee newEmployee = this.employeeService.createEmployee(employeeRequest);
            response.put("status", true);
            response.put("message", newEmployee);
            return ResponseEntity.ok().body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Employee employee = this.employeeService.getEmployeeById(id);
        if (employee != null) {
            response.put("success", true);
            response.put("message", employee);
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to retrieve employee by id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<?> getAllEmployees() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", this.employeeService.getAllEmployees());
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            Employee uEmployee = this.employeeService.updateEmployee(id, employeeRequest);
            if (uEmployee != null) {
                response.put("status", true);
                response.put("message", uEmployee);
                return ResponseEntity.ok().body(response);
            }
            response.put("success", false);
            response.put("message", "Employee not found with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (IllegalArgumentException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();

        boolean isDeleted = this.employeeService.deleteEmployee(id);

        if (isDeleted) {
            response.put("success", true);
            response.put("message", "Employee deleted successfully");
            return ResponseEntity.ok().body(response);
        }

        response.put("success", false);
        response.put("message", "Employee not found with id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<?> getEmployeeDetailsById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        EmployeeDetailsDTO employeeDetailsDTO = this.employeeService.getEmployeeDetailsById(id);
        if (employeeDetailsDTO != null) {
            response.put("success", true);
            response.put("message", employeeDetailsDTO);
            return ResponseEntity.ok().body(response);
        }
        response.put("success", false);
        response.put("message", "Failed to retrieve details of employee by id " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping(value = "/view")
    public ResponseEntity<?> getEmployeeView() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", this.employeeService.getEmployeeView());
        return ResponseEntity.ok().body(response);
    }
    
}
