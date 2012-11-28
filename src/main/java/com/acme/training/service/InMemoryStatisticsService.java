package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryStatisticsService implements ApplicationListener<OrderEvent> {

    private Map<Integer, OrderItem> foodStatistics = new HashMap<Integer, OrderItem>();
    private Map<Integer, RestaurantOrder> restaurantStatistics = new HashMap<Integer, RestaurantOrder>();

    public void onApplicationEvent(OrderEvent event) {
        for (RestaurantOrder restaurantOrder : event.getOrder().getRestaurantOrders()) {
            Collection<OrderItem> items = restaurantOrder.getOrderItems();
            for (OrderItem item : items) {
                doStatistics(item);
            }
        }
    }

    private void doStatistics(OrderItem item) {
        OrderItem orderItem = foodStatistics.get(item.getFood().getId());
        if (orderItem != null) {
            orderItem.addQuantity(item.getQuantity());
        } else {
            foodStatistics.put(item.getFood().getId(), new OrderItem(item.getQuantity(), item.getFood()));
        }
        RestaurantOrder restaurantOrder = restaurantStatistics.get(item.getFood().getRestaurant().getId());
        if (restaurantOrder == null) {
            restaurantOrder = new RestaurantOrder();
            restaurantOrder.setRestaurant(item.getFood().getRestaurant());
            restaurantStatistics.put(item.getFood().getRestaurant().getId(), restaurantOrder);
        }
        restaurantOrder.addOrderItem(item.getFood(), item.getQuantity());
    }

    public void printStatistics() {

        System.out.println();
        System.out.println("==== FOOD STATISTIC:");
        for (OrderItem item : foodStatistics.values()) {
            System.out.println(String.format(" %20s : %-4d * %-5.2f", item.getFood().getName(), item.getQuantity(),
                    item.getFood().getPrice()));
        }

        System.out.println();
        System.out.println("==== RESTAURANT STATISTIC:");
        for (RestaurantOrder restaurantOrder : restaurantStatistics.values()) {
            System.out.println(restaurantOrder.getRestaurant().getName());
            for (OrderItem item : restaurantOrder.getOrderItems()) {
                System.out.println(String.format(" %20s : %-4d * %-5.2f", item.getFood().getName(), item.getQuantity(),
                        item.getFood().getPrice()));
            }
            System.out.println("---------------");
            System.out.println("Összesen: " + restaurantOrder.getTotal());
            System.out.println("------------------------------");
        }

    }

}
