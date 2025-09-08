package com.skyscanner.hoenscannerexercise;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("kind")
    private String kind;
    
    @JsonProperty("title")
    private String title;
    
    // Empty constructor - Jackson needs this
    public SearchResult() {
    }
    
    // Constructor with all fields
    public SearchResult(String city, String kind, String title) {
        this.city = city;
        this.kind = kind;
        this.title = title;
    }
    
    // Getter methods
    public String getCity() {
        return city;
    }
    
    public String getKind() {
        return kind;
    }
    
    public String getTitle() {
        return title;
    }
    
    // Setter methods
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setKind(String kind) {
        this.kind = kind;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
}
