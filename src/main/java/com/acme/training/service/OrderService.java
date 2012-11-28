package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Order;

public interface OrderService {

    public void doOrder(CustomerOrder customerOrder);

    public Collection<CustomerOrder> getAllOrder();

    public CustomerOrder findById(String id);
    
    public int addNewShoppingCart(String customer);
    
    public ShoppingCart getShoppingCartById(int scId);

}