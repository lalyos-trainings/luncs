package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryNAVService implements ApplicationListener<OrderEvent>
{
    private static final Logger logger = LoggerFactory.getLogger(InMemoryNAVService.class);
    
    private Map<String, Integer> incomes = new HashMap<String, Integer>(); 
    
    private void doNAV(RestaurantOrder restaurantOrder)
    {
        Restaurant restaurant = restaurantOrder.getRestaurant();
        String restaurantName = restaurant.getName();
        
        Integer income = incomes.get(restaurantName);
        
        if (income != null)
        {
            income += restaurantOrder.getTotal();
        }
        else
        {
            income = restaurantOrder.getTotal();
        }
        
        incomes.put(restaurantName, income);
    }
    
    public void onApplicationEvent(OrderEvent event)
    {
        CustomerOrder customerOrder = event.getCustomerOrder();
        
        Collection<RestaurantOrder> restaurantOrders = customerOrder.getRestaurantOrders();
        Iterator<RestaurantOrder> iterator = restaurantOrders.iterator();
        while (iterator.hasNext() == true)
        {
            RestaurantOrder restaurantOrder = iterator.next();
            doNAV(restaurantOrder);
        }
    }

    public void printNAV()
    {
        logger.info("==== NAV ====");
        
        Iterator<Entry<String, Integer>> iterator = incomes.entrySet().iterator();
        while (iterator.hasNext() == true)
        {
            Entry<String, Integer> entry = iterator.next();
            logger.info(String.format("%-15s %6d YEN", entry.getKey(), entry.getValue()));
        }
    }
}
