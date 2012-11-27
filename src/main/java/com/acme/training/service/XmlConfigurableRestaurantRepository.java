package com.acme.training.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;

@Component
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

}
