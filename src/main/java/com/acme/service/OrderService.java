package com.acme.service;

import java.util.Collection;

import com.acme.domain.CustomerOrder;

public interface OrderService {

    public abstract void doOrder(CustomerOrder order);
    public Collection<CustomerOrder> getAllOrders();

}