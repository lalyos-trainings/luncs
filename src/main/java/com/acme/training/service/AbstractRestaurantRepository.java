package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository implements RestaurantRepository{

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);

    public AbstractRestaurantRepository() {
        super();
    }

    /**
     * @see com.acme.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food findFoodById(String restiName, String foodName) {
        Food tmp = null;
        Food r = null;
        boolean found = false;
        for (Restaurant resti : getAllRestaurants()) {
            if (resti.getName().equalsIgnoreCase(restiName)) {
                Iterator<Food> it = resti.getMenu().getFoods().iterator();
                while (!found && it.hasNext()) {
                    tmp = it.next();
                    if (tmp.getName().equalsIgnoreCase(foodName)) {
                        found = true;
                        r = tmp;
                    }
                }
            }
        }
        return r;
    }

    public Food findFoodByName(String foodName) {
        Food tmp = null;
        Food r = null;
        boolean found = false;
        for (Restaurant resti : getAllRestaurants()) {
            Iterator<Food> it = resti.getMenu().getFoods().iterator();
            while (!found && it.hasNext()) {
                tmp = it.next();
                if (tmp.getName().equalsIgnoreCase(foodName)) {
                    found = true;
                    r = tmp;
                }
            }
        }
        return r;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninmemoryrestaurantrepository: {}\n*************************", name);
    }

}