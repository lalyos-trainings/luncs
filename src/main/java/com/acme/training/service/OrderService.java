package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.CustomerOrder;

public interface OrderService {

    void doOrder(CustomerOrder order);

    Collection<CustomerOrder> getAllOrder();

    CustomerOrder findById(String id);

	int addNewShoppingCart(String customer);

	ShoppingCart getShoppingCartById(Integer cartId);

}