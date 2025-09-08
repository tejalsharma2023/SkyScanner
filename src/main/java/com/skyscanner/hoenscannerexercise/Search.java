package com.skyscanner.hoenscannerexercise;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    @JsonProperty("city")
    private String city;
    
    // Empty constructor - Jackson needs this
    public Search() {
    }
    
    // Constructor with city
    public Search(String city) {
        this.city = city;
    }
    
    // Getter method
    public String getCity() {
        return city;
    }
    
    // Setter method
    public void setCity(String city) {
        this.city = city;
    }
}
