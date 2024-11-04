package com.scotiabank.payroll.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDetailsDTO {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String cityName;

    private String address;

    private LocalDate dateBirth;

    private String telephone;

    private String title;

    private LocalDate hireDate;

    private String email;

    private BigDecimal salary;

    public EmployeeDetailsDTO() {
    }

    public EmployeeDetailsDTO(Long id, String firstName, String middleName, String lastName, String cityName,
            String address, LocalDate dateBirth, String telephone, String title, LocalDate hireDate, String email,
            BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cityName = cityName;
        this.address = address;
        this.dateBirth = dateBirth;
        this.telephone = telephone;
        this.title = title;
        this.hireDate = hireDate;
        this.email = email;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
}
