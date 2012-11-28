package com.acme.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;

public class AbstractRestaurantRepository implements RestaurantRepository {

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    protected ArrayList<Food> foodList = new ArrayList<Food>();
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public AbstractRestaurantRepository() {
        super();
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodbyId(int id) {        
        for (Food f: foodList){
            if (f.getId() == id){
                return f;
            }
        }
        return null;
    }

    public void setBeanName(String arg0) {
        logger.info(arg0);
    }

}