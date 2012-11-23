package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Order;

public interface OrderService {

    public abstract void doOrder(Order order);
    public Collection<Order> getAllOrders();

}