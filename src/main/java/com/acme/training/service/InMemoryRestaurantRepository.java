package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Food;
//import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository, BeanNameAware {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    static private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    
    public InMemoryRestaurantRepository() {}
    
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        System.out.println("itt");
        System.out.println(restaurantMap.keySet());
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setBeanName(String name) {
        
        logger.info("\n*******************\ninmemoryrestaurantrepository: " + name + "\n*********************");
        // TODO Auto-generated method stub
        
    }
}
