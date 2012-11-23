package com.epam.training.service;

import java.io.PrintWriter;

import com.epam.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private PrintWriter writer;
    private RestaurantRepository repo;
    
    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== next resti: " + restaurant);
        }
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }


}
