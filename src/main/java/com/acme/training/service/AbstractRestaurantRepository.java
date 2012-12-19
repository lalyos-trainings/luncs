package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.aop.Retry;
import com.acme.training.aop.Timer;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

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

    static Random rnd = new Random();
    
    @Retry(maxRetry=30)
    @Timer
    public Food findFoodById(Integer foodId) {
    	int nextInt = rnd.nextInt(10);
    	if (nextInt < 6) {
    		throw new RuntimeException("Uuuupss!!!");
    	}
        return foodMap.get(foodId);
    }

    public void setBeanName(String name) {
        logger.info("my name is: " + name);
    }

}