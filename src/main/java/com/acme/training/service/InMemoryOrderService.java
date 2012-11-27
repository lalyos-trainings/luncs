package com.acme.training.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService {
    public List<Order> orders = new LinkedList<Order>();
    @Autowired
    private ApplicationContext context;

    public void doOrder(Order o) {
        orders.add(o);
        OrderEvent oe = new OrderEvent(this, o);
        context.publishEvent(oe);
    }

    public List<Order> getOrders() {
        return orders;
    }

}
