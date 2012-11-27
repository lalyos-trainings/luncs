package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();

    public AbstractRestaurantRepository()
    {
        super();
    }

    public Collection<Restaurant> getAllRestaurants()
    {
        return restaurantMap.values();
    }

    public Food getFoodById(int foodId)
    {
        Food foundFood = null;
        
        Iterator<Restaurant> iterator = restaurantMap.values().iterator();
        
        while (iterator.hasNext() == true && foundFood == null)
        {
            Restaurant restaurant = iterator.next();
            Menu menu = restaurant.getMenu();
            Collection<Food> foods = menu.getFoods();
            
            Iterator<Food> foodIterator = foods.iterator();
            
            while (foodIterator.hasNext() == true)
            {
                Food food = foodIterator.next();
                if (food.getId() == foodId)
                {
                    foundFood = food;
                    break;
                }
            }
        }
        
        return foundFood;
    }

    public void setBeanName(String beanName)
    {
        logger.info("bean name: " + beanName);
    }

}