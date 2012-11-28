package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.CustomerOrder;

public interface OrderService {
    public void doOrder(CustomerOrder o);

    public List<CustomerOrder> getOrders();
}
