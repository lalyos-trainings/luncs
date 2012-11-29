package com.acme.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    public void onApplicationEvent(OrderEvent event) {
    	List<OrderItem> items = new ArrayList<OrderItem>();
		for (RestaurantOrder restaurantOrder : event.getOrder().getRestaurantOrders()) {
			items.addAll(restaurantOrder.getOrderItems());
		}
        for (OrderItem item : items) {
            doStatistic(item);
        }
    }
    private void doStatistic(OrderItem item) {
        Integer foodId = item.getFood().getId();
        
        OrderItem orderItem = foodStatistic.get(foodId);
        if (orderItem != null) {
            orderItem.addQuantity(item.getQuantity());
        } else {
            foodStatistic.put(foodId, item);
        }
    }

    public void printStatistic() {
        System.out.println("==== STATISTIC:");
        for (OrderItem item : foodStatistic.values()) {
            System.out.println(String.format(" %20s [%10s] : %-4d" , item.getFood().getRestaurant().getName(), item.getFood().getName(), item.getQuantity()));
        }
    }
}
