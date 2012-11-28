package com.acme.training.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;

@Component("xmlRest")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {
    
    @Autowired
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        for (Restaurant restaurant : restaurantMap.values()) {
            registerFood(restaurant);
        }
    }
}
