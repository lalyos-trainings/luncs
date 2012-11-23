package com.epam.training.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private final PrintWriter writer;
    private RestaurantRepository repo;

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }

    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                writer.println("  " + food.getName());
            }
        }
        writer.flush();
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

}
