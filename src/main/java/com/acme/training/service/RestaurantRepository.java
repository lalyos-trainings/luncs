package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();
    
//    public Food findFoodById(String restiName, String foodName);
//
    public Food findFoodByName(String foodName);

    public Food findFoodById(int foodId);
}