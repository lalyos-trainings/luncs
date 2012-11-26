package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository, BeanNameAware {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private Map<Integer, Food> foodMap = new HashMap<Integer, Food>();
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    
    public InMemoryRestaurantRepository() {
        addRestaurant(createResti1());
        addRestaurant(createResti2());        
    }
        
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        for (Restaurant restaurant : restaurantMap.values()) {
            registerFoods(restaurant);
        }
    }

    private void registerFoods(Restaurant restaurant) {
        for (Food food : restaurant.getMenu().getFoods()) {
            foodMap.put(food.getId(), food);
        }
        
    }

    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
        registerFoods(restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("pacal", 500));
        m1.getFoods().add(new Food("toltott kaposzta",750));
        m1.getFoods().add(new Food("bableves", 690));
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("lencse leves", 400));
        m1.getFoods().add(new Food("gyros",850));
        m1.getFoods().add(new Food("baklava", 300));
        return r1;
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food findFoodById(Integer foodId) {
        return foodMap.get(foodId);
    }

    public void setBeanName(String name) {
        logger.info("my name is: " + name);
    }
}
