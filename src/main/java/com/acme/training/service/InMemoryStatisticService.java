package com.acme.training.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>
{
    private Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    
    private void doStatistic(OrderItem item)
    {
        int foodId = item.getFood().getId();
        
        OrderItem orderItem = foodStatistic.get(foodId);
        
        if (orderItem != null)
        {
            orderItem.addQuantity(item.getQuantity());
        }
        else
        {
            foodStatistic.put(foodId, item);
        }
    }
    
    public void printStatistic()
    {
        System.out.println("=== STATISTIC ===");
        
        Iterator<OrderItem> iterator = foodStatistic.values().iterator();
        while (iterator.hasNext() == true)
        {
            OrderItem item = iterator.next();
            
            System.out.println(item);
        }
    }
    
    public void onApplicationEvent(OrderEvent event)
    {
        List<OrderItem> orderItems = event.getOrder().getOrderItems();
        int i = 0;
        while (i < orderItems.size())
        {
            OrderItem item = orderItems.get(i);
            doStatistic(item);
            
            i++;
        }
    }
    
}
