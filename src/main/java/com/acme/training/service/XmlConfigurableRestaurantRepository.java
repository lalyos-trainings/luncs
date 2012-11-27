package com.acme.training.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;


@Component("xml")
//@Qualifier("xml")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {

   

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
            this.restaurantMap = restaurantMap;
            Set<String> keySet = restaurantMap.keySet();
    //        for (String key : keySet) {
    //            System.out.println("next repo key:" + key);
    //        }
        }

}
