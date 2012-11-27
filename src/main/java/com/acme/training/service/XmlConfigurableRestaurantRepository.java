package com.acme.training.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;

@Component("XmlRepo")
@Qualifier("xml")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {
    @Override
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }
}
