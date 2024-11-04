package com.scotiabank.payroll.service.employee;

import java.util.List;

import com.scotiabank.payroll.dto.EmployeeDetailsDTO;
import com.scotiabank.payroll.dto.EmployeeViewDTO;
import com.scotiabank.payroll.model.Employee;
import com.scotiabank.payroll.request.EmployeeRequest;

public interface EmployeeService {

    public Employee createEmployee(EmployeeRequest employeeRequest);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest);
    public boolean deleteEmployee(Long id);
    public EmployeeDetailsDTO getEmployeeDetailsById(Long id);
    public List<EmployeeViewDTO> getEmployeeView();
    
}
