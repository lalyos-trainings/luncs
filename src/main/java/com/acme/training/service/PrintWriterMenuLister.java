package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private PrintWriter writer;
    private RestaurantRepository restaurantRepository;
    
    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void doList() {
        for (Restaurant restaurant : restaurantRepository.getAllRestaurants()) {
            writer.println("=== next resti: " + restaurant + "\n===");
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                writer.println(food);
            }
        }

        writer.flush();
    }

    public RestaurantRepository getRepo() {
        return restaurantRepository;
    }

    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

}
