package com.epam.training;


import java.util.Collection;

import com.epam.training.domain.Food;

import com.epam.training.domain.Restaurant;
import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.RestaurantRepository;


public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RestaurantRepository repo = new InMemoryRestaurantRepository();
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            System.out.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                System.out.println("  " + food.getName());
            }
            
        }

    }

}
