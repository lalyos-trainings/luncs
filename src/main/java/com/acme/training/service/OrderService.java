package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.CustomerOrder;

public interface OrderService {

    public void doOrder(CustomerOrder order);

    public Collection<CustomerOrder> getAllOrder();

    public CustomerOrder findById(Integer id);
}