package com.acme.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;

@Component("xmlRepo")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository{

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        for(Restaurant rest:restaurantMap.values())
            for(Food food : rest.getMenu().getFoods()){
                foodList.add(food);
            }
    }
}
