package com.acme.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;

import com.acme.training.domain.OrderItem;

public class InMemoryStatisticService implements ApplicationListener<OrderEvent> {

    Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();

    public void onApplicationEvent(OrderEvent event) {
        List<OrderItem> items = event.getOrder().getItems();
        for (OrderItem item : items) {
            doStatistic(item);
        }
    }

    private void doStatistic(OrderItem item) {
        Integer foodId = item.getFood().getId();
        int quantity = item.getQuantity();

        OrderItem orderItem = foodStatistic.get(foodId);
        if (orderItem != null) {
            orderItem.addQuantity(item.getQuantity());
        } else {
            foodStatistic.put(foodId, item);
        }

    }
}
