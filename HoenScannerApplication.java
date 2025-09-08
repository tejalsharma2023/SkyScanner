package com.skyscanner.hoenscannerexercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "HoenScanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HoenScannerConfiguration configuration,
                    final Environment environment) throws IOException {
        
        // Load search results from JSON files
        ObjectMapper objectMapper = new ObjectMapper();
        List<SearchResult> searchResults = new ArrayList<>();
        
        // Load rental cars
        try (InputStream rentalCarsStream = getClass().getResourceAsStream("/rental_cars.json")) {
            List<SearchResult> rentalCars = objectMapper.readValue(rentalCarsStream, 
                new TypeReference<List<SearchResult>>() {});
            searchResults.addAll(rentalCars);
        }
        
        // Load hotels
        try (InputStream hotelsStream = getClass().getResourceAsStream("/hotels.json")) {
            List<SearchResult> hotels = objectMapper.readValue(hotelsStream, 
                new TypeReference<List<SearchResult>>() {});
            searchResults.addAll(hotels);
        }
        
        // Register the search resource
        final SearchResource searchResource = new SearchResource(searchResults);
        environment.jersey().register(searchResource);
    }
}
