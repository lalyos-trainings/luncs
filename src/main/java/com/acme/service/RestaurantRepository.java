package com.acme.service;

import java.util.Collection;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();
    public Food getFoodbyId(int id);

}