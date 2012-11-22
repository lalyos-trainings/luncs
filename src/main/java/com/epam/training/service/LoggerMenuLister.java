package com.epam.training.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class LoggerMenuLister implements MenuLister {

    private RestaurantRepository repo;
    private static Logger logger = LoggerFactory.getLogger(LoggerMenuLister.class);
    
    public LoggerMenuLister(){
    }
    
    public void setRestaurantRepository(RestaurantRepository repo) {
        this.repo = repo;
        
    }

    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            logger.info("=== next rest: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                logger.info("  " + food.getName());
            }
            
        }
        
    }

}
