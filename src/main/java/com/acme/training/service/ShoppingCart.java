package com.acme.training.service;

import com.acme.training.domain.Address;

public interface ShoppingCart {

    public abstract ShoppingCart withCustomer(String customer);

    public abstract ShoppingCart withDeliveryAddress(Address deliveryAddress);

    public abstract ShoppingCart withBillingAddress(Address billingAddress);

    public abstract ShoppingCart withFood(int id);

    public abstract ShoppingCart withFood(int id, int quantity);

    public abstract void checkout();

    public abstract OrderService getOrderService();

    public abstract void setOrderService(OrderService orderService);

}