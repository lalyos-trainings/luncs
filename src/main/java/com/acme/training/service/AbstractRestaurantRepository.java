package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository implements RestaurantRepository{

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public AbstractRestaurantRepository() {
        super();
    }
    
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodById(int id) {
        Set<String> restaurants= restaurantMap.keySet();
        Iterator<String> iter = restaurants.iterator();
        while (iter.hasNext()) {
          Restaurant restaurant = restaurantMap.get(iter.next());
          Collection<Food> foods = restaurant.getMenu().getFoods();
          for (Food food : foods) {
              if(food.getId() == id)
                  return food;
              }          
        }        
        return null;        
    }

    public void setBeanName(String bean) {
        logger.info("bean:" + bean);
        
    }

}