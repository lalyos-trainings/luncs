package com.acme.training.repository;

import java.util.Collection;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();

    public Food findFoodById(Integer foodId);

}