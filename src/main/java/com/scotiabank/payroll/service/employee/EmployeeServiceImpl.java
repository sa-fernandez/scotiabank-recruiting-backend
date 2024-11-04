package com.scotiabank.payroll.service.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotiabank.payroll.dto.EmployeeDetailsDTO;
import com.scotiabank.payroll.dto.EmployeeViewDTO;
import com.scotiabank.payroll.model.City;
import com.scotiabank.payroll.model.Employee;
import com.scotiabank.payroll.model.Position;
import com.scotiabank.payroll.repository.CityRepository;
import com.scotiabank.payroll.repository.EmployeeRepository;
import com.scotiabank.payroll.repository.PositionRepository;
import com.scotiabank.payroll.request.EmployeeRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PositionRepository positionRepository;

    private static final String PHONE_PATTERN = "^\\+57[0-9]{10}";

    private static final String ADDRESS_PATTERN = "^(Calle|Carrera|Transversal|Diagonal|Calle|KR|AC)\\s\\d{1,3}[a-zA-Z]?\\s#\\s\\d{1,3}(\\s-\\s\\d{1,3})?$";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private boolean isPhoneValid(String telephone) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(telephone);
        return matcher.matches();
    }

    private boolean isAddressValid(String address) {
        Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        if (!this.isPhoneValid(employeeRequest.getTelephone())) {
            throw new IllegalArgumentException("Phone number does not follow the required pattern");
        }

        if (!this.isAddressValid(employeeRequest.getAddress())) {
            throw new IllegalArgumentException("Address does not follow the required pattern");
        }

        try {
            LocalDate birthDate = LocalDate.parse(employeeRequest.getDateBirth(), FORMATTER);
            LocalDate hiredDate = LocalDate.parse(employeeRequest.getHireDate(), FORMATTER);
            City city = this.cityRepository.findById(employeeRequest.getIdCity()).orElseThrow(() -> new IllegalArgumentException("City with id " + employeeRequest.getIdCity() + " not found"));
            Position position = this.positionRepository.findById(employeeRequest.getIdPosition()).orElseThrow(() -> new IllegalArgumentException("Position with id " + employeeRequest.getIdPosition() + " not found"));

            Employee newEmployee = new Employee(employeeRequest.getFirstName(), employeeRequest.getMiddleName(), employeeRequest.getLastName(), employeeRequest.getAddress(), birthDate, hiredDate, employeeRequest.getEmail(), employeeRequest.getTelephone(), employeeRequest.getStatus(), city, position);
            return this.employeeRepository.save(newEmployee);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format, expected dd-MM-yyyy");
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if (!this.employeeRepository.existsById(id)) {
            return null;
        }
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest) {
        if (!this.employeeRepository.existsById(id)) {
            return null;
        }

        if (employeeRequest.getTelephone() != null && !this.isPhoneValid(employeeRequest.getTelephone())) {
            throw new IllegalArgumentException("Phone number does not follow the required pattern");
        }

        if (employeeRequest.getAddress() != null && !this.isAddressValid(employeeRequest.getAddress())) {
            throw new IllegalArgumentException("Address does not follow the required pattern");
        }

        LocalDate birthDate = null;
        LocalDate hireDate = null;

        try {
            if (employeeRequest.getDateBirth() != null) {
                birthDate = LocalDate.parse(employeeRequest.getDateBirth(), FORMATTER);
            }

            if (employeeRequest.getHireDate() != null) {
                hireDate = LocalDate.parse(employeeRequest.getHireDate(), FORMATTER);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format, expected dd-MM-yyyy");
        }

        City city = null;
        if (employeeRequest.getIdCity() != null) {
            city = this.cityRepository.findById(employeeRequest.getIdCity()).orElseThrow(() -> new IllegalArgumentException("City with id " + employeeRequest.getIdCity() + " not found"));
        }

        Position position = null;
        if (employeeRequest.getIdPosition() != null) {
            position = this.positionRepository.findById(employeeRequest.getIdPosition()).orElseThrow(() -> new IllegalArgumentException("Position with id " + employeeRequest.getIdPosition() + " not found"));
        }

        Employee uEmployee = this.employeeRepository.findById(id).get();
        
        if (employeeRequest.getFirstName() != null) {
            uEmployee.setFirstName(employeeRequest.getFirstName());
        }

        if (employeeRequest.getMiddleName() != null) {
            uEmployee.setMiddleName(employeeRequest.getMiddleName());
        }
        
        if (employeeRequest.getLastName() != null) {
            uEmployee.setLastName(employeeRequest.getLastName());
        }

        if (employeeRequest.getAddress() != null) {
            uEmployee.setAddress(employeeRequest.getAddress());
        }

        if (birthDate != null) {
            uEmployee.setDateBirth(birthDate);
        }

        if (hireDate != null) {
            uEmployee.setHireDate(hireDate);
        }

        if (employeeRequest.getEmail() != null) {
            uEmployee.setEmail(employeeRequest.getEmail());
        }

        if (employeeRequest.getTelephone() != null) {
            uEmployee.setTelephone(employeeRequest.getTelephone());
        }

        if (employeeRequest.getStatus() != null) {
            uEmployee.setStatus(employeeRequest.getStatus());
        }

        if (city != null) {
            uEmployee.setCity(city);
        }

        if (position != null) {
            uEmployee.setPosition(position);
        }

        return this.employeeRepository.save(uEmployee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (!this.employeeRepository.existsById(id)) {
            return false;
        }
        this.employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
        if (!this.employeeRepository.existsById(id)) {
            return null;
        }
        Employee employee = this.employeeRepository.findById(id).get();
        return new EmployeeDetailsDTO(employee.getId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getCity().getName(), employee.getAddress(), employee.getDateBirth(), employee.getTelephone(), employee.getPosition().getTitle(), employee.getHireDate(), employee.getEmail(), employee.getPosition().getSalary());
    }

    @Override
    public List<EmployeeViewDTO> getEmployeeView() {
        List<EmployeeViewDTO> employeeViewDTOs = new ArrayList<>();
        List<Employee> allEmployees = this.employeeRepository.findAll();
        for (Employee employee : allEmployees) {
            employeeViewDTOs.add(new EmployeeViewDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getPosition().getTitle(), employee.getHireDate(), employee.getStatus()));
        }
        return employeeViewDTOs;
    }
    
}
