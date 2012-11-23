package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();
    public Food getFoodById(int id);
}