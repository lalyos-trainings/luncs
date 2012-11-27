package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;

import com.acme.training.domain.OrderItem;

public class InMemoryStatisticsService implements ApplicationListener<OrderEvent>{

    private Map<String, OrderItem> foodStatistics = new HashMap<String, OrderItem>();
    
    public void onApplicationEvent(OrderEvent event) {
        Collection<OrderItem> items = event.getOrder().getOrderItems().values();
        for(OrderItem item : items){
            doStatistics(item);
        }
    }

    private void doStatistics(OrderItem item) {
        String foodId = item.getFood().getName();
        OrderItem orderItem = foodStatistics.get(foodId);
        if(orderItem != null){
            orderItem.addQuantity(item.getQuantity());
        }
        else{
            foodStatistics.put(foodId, item);
        }
        
    }
    
    

    
}
