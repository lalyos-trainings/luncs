package com.acme.training.service;

import java.util.LinkedList;
import java.util.List;

import com.acme.training.domain.Order;

public class InMemoryOrderService implements OrderService {
    public List<Order> orders = new LinkedList<Order>();

    public void doOrder(Order o) {
        orders.add(o);
    }

    public List<Order> getOrders() {
        return orders;
    }

}
