package com.epam.training.service;

import java.util.List;

import com.epam.training.domain.Order;

public interface OrderService {
    public void doOrder(Order o);

    public List<Order> getOrders();
}
