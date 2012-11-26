package com.acme.service;

import java.util.Collection;

import com.acme.domain.Order;

public interface OrderService {

    public abstract void doOrder(Order order);
    public Collection<Order> getAllOrders();

}