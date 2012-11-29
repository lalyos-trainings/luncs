package com.acme.training.service;

import java.util.List;

public interface OrderService {
    
    public void doOrder(CustomerOrder order);
    
    public List<CustomerOrder> getAllOrders();

}
