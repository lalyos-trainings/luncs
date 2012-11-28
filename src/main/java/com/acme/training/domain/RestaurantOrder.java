package com.acme.training.domain;

import java.util.Collection;

public class RestaurantOrder {

    private Restaurant restaurant;
    private Collection<OrderItem> orderItems;

    /**
     * @param retaurant
     * @param orderItems
     */
    public RestaurantOrder(Restaurant restaurant, Collection<OrderItem> orderItems) {
        super();
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Integer getTotal() {
        Integer result = 0;
        for (OrderItem nextitem : orderItems) {
            result += nextitem.getTotal();
        }
        return result;
    }

    public void printBill() {
        for (OrderItem nextOrderItem : orderItems) {
            System.out.println(nextOrderItem);
        }

    }
}
