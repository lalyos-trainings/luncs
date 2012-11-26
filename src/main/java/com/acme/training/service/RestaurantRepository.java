package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();

}