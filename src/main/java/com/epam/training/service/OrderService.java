package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Order;

public interface OrderService {

    public void doOrder(Order order);

    public Collection<Order> getAllOrder();

    public Order findById(String id);

}