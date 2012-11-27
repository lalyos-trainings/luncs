package com.acme.service;

import java.util.Map;

import com.acme.domain.Restaurant;

public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository{

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }
}
