package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class AbstractRestaurantRepository implements RestaurantRepository, BeanNameAware{

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
        Iterator<Food> it = foodMap.values().iterator();
        while (!found && it.hasNext()) {
            tmp = it.next();
            if (tmp.getName().equalsIgnoreCase(foodName)
                    && tmp.getRestaurant().getName().equalsIgnoreCase(restiName)) {
                found = true;
                r = tmp;
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

    public void registerFood(Restaurant restaurant){
        for(Food food : restaurant.getMenu().getFoods()){
            food.setId(maxId);
            foodMap.put(maxId, food);
            maxId++;
        }
    }
    
    public Map<Integer, Food> getFoodMap() {
        return foodMap;
    }

    public void setBeanName(String name) {
        logger.info("*************************\nabstractrestaurantrepository: {}\n*************************", name);
    }

}