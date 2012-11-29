package com.acme.training.service;

import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.Menu;

@Component("memoryRepository")
public class InMemoryRestaurantRepository extends AbstractRestaurantRepository implements BeanNameAware { 
    public InMemoryRestaurantRepository() {}
    
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }
    
    public Food getFoodById(int id) {
        for (Map.Entry<String, Restaurant> entry : restaurantMap.entrySet()) {
            Menu menu = entry.getValue().getMenu();
            for (Food f : menu.getFoods()) {
                if ( f.getId() == id) {
                    return f;
                }
            }
            
        }
        return null;
    }
}
