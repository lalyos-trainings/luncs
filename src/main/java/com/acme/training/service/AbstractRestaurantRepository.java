package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository implements RestaurantRepository{

    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private Map<Integer, Food> foodMap = new HashMap<Integer, Food>();
    private static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    
    private int maxId = 0;
    
    public AbstractRestaurantRepository() {
        super();
    }

    /**
     * @see com.acme.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food findFoodByRestiAndName(String restiName, String foodName) {
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

//    public Food findFoodById(int foodId) {
//        Food tmp = null;
//        Food r = null;
//        boolean found = false;
//        for (Restaurant resti : getAllRestaurants()) {
//            Iterator<Food> it = resti.getMenu().getFoods().iterator();
//            while (!found && it.hasNext()) {
//                tmp = it.next();
//                if (tmp.getId() == foodId) {
//                    found = true;
//                    r = tmp;
//                }
//            }
//        }
//        return r;
//    }
//
    public Food findFoodById(int foodId) {
        return foodMap.get(foodId);
    }

    public void registerFoods(Restaurant restaurant){
        for(Food food : restaurant.getMenu().getFoods()){
            foodMap.put(maxId, food);
            maxId++;
        }
    }
    
    public Map<Integer, Food> getFoodMap() {
        return foodMap;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninmemoryrestaurantrepository: {}\n*************************", name);
    }

}