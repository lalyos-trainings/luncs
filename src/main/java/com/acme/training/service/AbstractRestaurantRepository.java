package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository {

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    protected final Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public AbstractRestaurantRepository() {
        super();
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public Food getFoodById(int id) {
        for (Restaurant r : restaurantMap.values()) {
            for (Food f : r.getMenu().getFoods()) {
                if (f.getId() == id) {
                    return f;
                }
            }
        }
        return null;
    }

}