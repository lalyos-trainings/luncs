package com.epam.training.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private PrintWriter writer;
    private RestaurantRepository repo;
    
    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
        writer.println("nna");
    }
    
    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
//            writer.println("=== next resti: " + restaurant.getName());
            System.out.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                System.out.println("  " + food.getName());
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
