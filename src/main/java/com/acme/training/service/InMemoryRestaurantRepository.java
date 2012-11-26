package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@Component("memoryRest")
@Scope("singleton")
public class InMemoryRestaurantRepository implements RestaurantRepository, BeanNameAware {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    private Locale locale;

    public InMemoryRestaurantRepository() {
        super();
    }

    /**
     * @see com.acme.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public void addRestaurant(String key, Restaurant restaurant) {
        restaurantMap.put(key, restaurant);
    }

    public void removeRestaurant(String key) {
        restaurantMap.remove(key);
    }

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
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

    public Food findFoodById(String foodName) {
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
