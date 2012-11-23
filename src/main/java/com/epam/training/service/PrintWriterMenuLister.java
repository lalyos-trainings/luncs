package com.epam.training.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {
    
    private RestaurantRepository repo;
    private PrintWriter printWriter;
    
    public PrintWriterMenuLister(PrintWriter printWriter){        
        this.printWriter = printWriter;
    }

    public void setRestaurantRepository(RestaurantRepository repo) {
        this.repo = repo;        
    }

    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            printWriter.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                String format = String.format("Food %-15s [%5d HUF]", food.getName(), food.getPrice());
                printWriter.println(format);
            }
            
        }
        
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

}
