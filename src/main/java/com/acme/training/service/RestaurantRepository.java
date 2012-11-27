package com.acme.training.service;

import java.util.Collection;
import java.util.Map;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();
    
    public Food findFoodByRestiAndName(String restiName, String foodName);

    public Food findFoodById(int foodId);
    
    public Map<Integer, Food> getFoodMap();
}