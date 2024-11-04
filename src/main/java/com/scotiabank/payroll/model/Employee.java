package com.scotiabank.payroll.model;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String firstName;

    private String middleName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String address;

    @Nonnull
    private LocalDate dateBirth;

    @Nonnull
    private LocalDate hireDate;

    @Nonnull
    private String email;

    @Nonnull
    private String telephone;

    @Nonnull
    private String status;

    @ManyToOne
    private City city;

    @ManyToOne
    private Position position;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, String address, LocalDate dateBirth,
            LocalDate hireDate, String email, String telephone, String status, City city, Position position) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.dateBirth = dateBirth;
        this.hireDate = hireDate;
        this.email = email;
        this.telephone = telephone;
        this.status = status;
        this.city = city;
        this.position = position;
    }

    public Employee(Long id, String firstName, String middleName, String lastName, String address, LocalDate dateBirth,
            LocalDate hireDate, String email, String telephone, String status) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.dateBirth = dateBirth;
        this.hireDate = hireDate;
        this.email = email;
        this.telephone = telephone;
        this.status = status;
    }

    public Employee(Long id, String firstName, String middleName, String lastName, String address, LocalDate dateBirth,
            LocalDate hireDate, String email, String telephone, String status, City city, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.dateBirth = dateBirth;
        this.hireDate = hireDate;
        this.email = email;
        this.telephone = telephone;
        this.status = status;
        this.city = city;
        this.position = position;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
