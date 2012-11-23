package com.epam.training.service;

import java.util.List;

import com.epam.training.domain.Order;

public interface OrderService 
{
    void doOrder(Order order);
    List<Order> getAllOrders();
}
