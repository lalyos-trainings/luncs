package com.acme.training.service;

import java.util.Collection;

import com.acme.training.aop.Timer;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();

    
    public Food findFoodById(Integer foodId);

}