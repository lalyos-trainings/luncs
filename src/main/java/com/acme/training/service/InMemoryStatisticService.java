package com.acme.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    private Logger logger = LoggerFactory.getLogger(InMemoryStatisticService.class);

    public void onApplicationEvent(OrderEvent event) {
        List<RestaurantOrder> restaurantOrders = event.getCustomerOrder().getRestaurantOrders();
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            for (OrderItem orderItem : restaurantOrder.getOrderItems().values()) {
                doStatistic(orderItem);
            }
        }
    }
    private void doStatistic(OrderItem item) {
        logger.info("next OrderItem:" + item.toString());

        Integer foodId = item.getFood().getId();
        
        OrderItem orderItem = foodStatistic.get(foodId);
        if (orderItem != null) {
            orderItem.addQuantity(item.getQuantity());
        } else {
            foodStatistic.put(foodId, new OrderItem(item));
        }
    }

    public void printStatistic() {
        System.out.println("==== STATISTIC:");
        for (OrderItem item : foodStatistic.values()) {
            System.out.println(String.format(" %20s [%10s] : %-4d" , item.getFood().getRestaurant().getName(), item.getFood().getName(), item.getQuantity()));
        }
    }
}
