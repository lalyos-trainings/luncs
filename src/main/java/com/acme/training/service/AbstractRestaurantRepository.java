package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.exception.FoodNotFoundException;

public class AbstractRestaurantRepository implements RestaurantRepository {

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private Map<Integer, Food> foodMap = new HashMap<Integer, Food>();
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public AbstractRestaurantRepository() {
        super();
    }

    protected void registerFoods(Restaurant restaurant) {
        for (Food food : restaurant.getMenu().getFoods()) {
            foodMap.put(food.getId(), food);
        }
        
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food findFoodById(Integer foodId) throws FoodNotFoundException {
        Food food = foodMap.get(foodId);
        if (food == null) {
            throw new FoodNotFoundException("Food with id: "+foodId+" was not found in the restaurant repository.");
        }
        return food;
    }

    public void setBeanName(String name) {
        logger.info("my name is: " + name);
    }

}