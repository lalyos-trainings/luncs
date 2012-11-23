package com.epam.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.epam.training.domain.Food;
import com.epam.training.domain.Menu;
import com.epam.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    
    public InMemoryRestaurantRepository() {}
    
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        System.out.println("itt");
        System.out.println(restaurantMap.keySet());
    }

    /* (non-Javadoc)
     * @see com.epam.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
