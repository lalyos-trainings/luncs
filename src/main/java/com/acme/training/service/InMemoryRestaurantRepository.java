package com.acme.training.service;

import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

//import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

@Component("memoryRepository")
public class InMemoryRestaurantRepository extends AbstractRestaurantRepository implements BeanNameAware {

    public InMemoryRestaurantRepository() {}
    
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }
}
