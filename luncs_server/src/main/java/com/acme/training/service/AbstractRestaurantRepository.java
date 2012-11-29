package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.acme.training.domain.Restaurant;

public abstract class AbstractRestaurantRepository implements RestaurantRepository {

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    protected static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public void setBeanName(String name) {
        
        logger.info("\n*******************\ninmemoryrestaurantrepository: " + name + "\n*********************");
        // TODO Auto-generated method stub
        
    }

}