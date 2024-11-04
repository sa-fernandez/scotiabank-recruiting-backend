package com.scotiabank.payroll.request;

public class CityRequest {

    private Long id;

    private String name;

    public CityRequest() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
