package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    Map<Integer, OrderItem> foodStatistics = new HashMap<Integer, OrderItem>();
    
    public void onApplicationEvent(OrderEvent event) {
        CustomerOrder order = event.getOrder();
        Map<String, RestaurantOrder> restaurantOrders = order.restaurantOrders();
        for (RestaurantOrder value : restaurantOrders.values()) {
            Collection<OrderItem> orderItems = value.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                doStatistic(orderItem);
            }
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
        System.out.println("=========ORDER STAT========");
        Collection<OrderItem> items = foodStatistics.values();
        for(OrderItem item : items){
            System.out.println("{ " + item.getFood().getRestaurant().getName() + " } " + item.getFood().getName() + " : " + item.getQuantity());
        }
    }
}
