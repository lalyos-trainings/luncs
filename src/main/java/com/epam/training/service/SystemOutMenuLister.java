package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class SystemOutMenuLister implements MenuLister {
    
    private RestaurantRepository repo;
    
    public void setRestaurantRepository(RestaurantRepository repo){
        this.repo = repo;
    }

    public void doList(){       
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            System.out.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                System.out.println("  " + food.getName());
            }
            
        }
    }
}
