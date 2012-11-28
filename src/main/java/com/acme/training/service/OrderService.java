package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.CustomerOrder;

public interface OrderService 
{
    void doOrder(CustomerOrder order);
    List<CustomerOrder> getAllOrders();
}
