package com.acme.training.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class InMemoryOrderService implements OrderService {
    public List<CustomerOrder> orders = new LinkedList<CustomerOrder>();
    @Autowired
    private ApplicationContext context;

    public void doOrder(CustomerOrder o) {
        orders.add(o);
        OrderEvent oe = new OrderEvent(this, o);
        context.publishEvent(oe);
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

}
