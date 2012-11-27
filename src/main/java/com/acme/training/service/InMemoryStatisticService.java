package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    Map<Integer, OrderItem> foodStatistics = new HashMap<Integer, OrderItem>();
    public void onApplicationEvent(OrderEvent event) {
        List<OrderItem> orderItems = event.getOrder().getOrderItems();
        for(OrderItem item : orderItems){
            doStatistic(item);
        }
    }
    private void doStatistic(OrderItem item) {
        int foodId = item.getFood().getId();
        
        OrderItem orderItem = foodStatistics.get(foodId);
        if(orderItem!=null)
            orderItem.addQuantity(item.getQuantity());
        else
            foodStatistics.put(foodId, item);        
    }
    public void printStat(){
        System.out.println("============STAT===========");
        Collection<OrderItem> items = foodStatistics.values();
        for(OrderItem item : items){
            System.out.println(item.getQuantity() + "  " + "  " + item.getFood());
        }
    }
}
