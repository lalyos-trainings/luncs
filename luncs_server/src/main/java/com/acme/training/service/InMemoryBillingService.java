package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;

@Component
public class InMemoryBillingService implements ApplicationListener<OrderEvent> {
    
    Map<Restaurant, Integer> income = new HashMap<Restaurant, Integer>();

    public void onApplicationEvent(OrderEvent event) {
        RestaurantOrder restaurantOrder = event.getOrder().getRestaurantOrder();
        for (OrderItem item : restaurantOrder.getFoods()) {
            Restaurant restaurant = item.getFood().getRestaurant();
            Integer i;
            if ( (i = income.get(restaurant)) == null ) {
                income.put(restaurant, item.getCount() * item.getFood().getPrice());
            } else {
               i += (item.getFood().getPrice() * item.getCount()); 
            }
        }
    }
    
    public void stats() {
       for (Map.Entry<Restaurant, Integer> i : income.entrySet()) {
           System.out.println( String.format("restaurant: %s income: %d", i.getKey().getName(), i.getValue()));
       }
    }

}
