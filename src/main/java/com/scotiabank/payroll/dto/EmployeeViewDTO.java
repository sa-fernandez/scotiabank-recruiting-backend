package com.scotiabank.payroll.dto;

import java.time.LocalDate;

public class EmployeeViewDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String positionTitle;

    private LocalDate dateArrival;

    private String status;

    public EmployeeViewDTO() {
    }

    public EmployeeViewDTO(Long id, String firstName, String lastName, String positionTitle, LocalDate dateArrival,
            String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionTitle = positionTitle;
        this.dateArrival = dateArrival;
        this.status = status;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
