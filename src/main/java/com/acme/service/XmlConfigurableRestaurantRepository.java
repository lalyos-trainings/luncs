package com.acme.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.domain.Restaurant;

@Component("xmlRepo")
@Qualifier("xml")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository{

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }
}
