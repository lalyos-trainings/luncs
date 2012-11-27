package com.acme.training.service;

import java.util.Map;

import com.acme.training.domain.Restaurant;

public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        for (Restaurant restaurant : restaurantMap.values()) {
            registerFoods(restaurant);
        }
    }

}
