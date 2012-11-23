package com.epam.training.service;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderService implements OrderService {
    
    List<Order> orders = new ArrayList<Order>();

    public void doOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

}
