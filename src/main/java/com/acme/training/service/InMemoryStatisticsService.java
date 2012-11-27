package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;

@Component
public class InMemoryStatisticsService implements ApplicationListener<OrderEvent>{

    private Map<Integer, OrderItem> foodStatistics = new HashMap<Integer, OrderItem>();
    
    public void onApplicationEvent(OrderEvent event) {
        Collection<OrderItem> items = event.getOrder().getOrderItems().values();
        for(OrderItem item : items){
            doStatistics(item);
        }
    }

    private void doStatistics(OrderItem item) {
        OrderItem orderItem = foodStatistics.get(item.getFood().getId());
        if(orderItem != null){
            orderItem.addQuantity(item.getQuantity());
        }
        else{
            foodStatistics.put(item.getFood().getId(), new OrderItem(item.getQuantity(), item.getFood()));
        }
        
    }
    
    public void printStatistics() {
        System.out.println("==== STATISTIC:");
        for (OrderItem item : foodStatistics.values()) {
            System.out.println(String.format(" %20s : %-4d * %-5.2f" , item.getFood().getName(), item.getQuantity(), item.getFood().getPrice()));
        }
    }
    
}
