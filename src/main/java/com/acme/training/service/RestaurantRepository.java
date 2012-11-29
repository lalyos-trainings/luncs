package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.exception.FoodNotFoundException;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();

    public Food findFoodById(Integer foodId) throws FoodNotFoundException;

}