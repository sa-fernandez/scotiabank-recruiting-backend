package com.scotiabank.payroll.request;

import java.math.BigDecimal;

public class PositionRequest {

    private Long id;

    private String title;

    private BigDecimal salary;

    public PositionRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
}
