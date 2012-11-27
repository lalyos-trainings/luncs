package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent> {

    Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();

    public void onApplicationEvent(OrderEvent event) {
        for (OrderItem i : event.getOrder().getOrderItems()) {
            doStatistic(i);
        }
    }

    private void doStatistic(OrderItem i) {
        Integer foodId = i.getFood().getId();

        OrderItem orderItem = foodStatistic.get(foodId);
        if (orderItem != null) {
            orderItem.addQuantity(i.getQuantity());
        } else {
            foodStatistic.put(foodId, i);
        }
    }

    public void printStatistics() {
        System.out.println("=== STATISTICS");
        for (OrderItem oi : foodStatistic.values()) {
            System.out.println(String.format("%s %d", oi.getFood().getName(), oi.getQuantity()));
        }
    }
}
