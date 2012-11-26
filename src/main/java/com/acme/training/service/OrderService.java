package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.Order;

public interface OrderService {

    public void doOrder(Order order);
    public List<Order> getAllOrders();
}
