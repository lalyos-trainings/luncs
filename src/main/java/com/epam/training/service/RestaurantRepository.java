package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public interface RestaurantRepository {

    public Collection<Restaurant> getAllRestaurants();
    
   // Food getFoodById ( int id ) ;

}


