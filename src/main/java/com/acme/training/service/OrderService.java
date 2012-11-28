package com.acme.training.service;

import java.util.Collection;

import com.acme.training.domain.CustomerOrder;

public interface OrderService {

    public void doOrder(CustomerOrder order);
    public Collection<CustomerOrder> getAllOrders();
//    public Collection<ShoppingCart> getShoppingCarts();
    public ShoppingCart getShoppingCart(int id);
    public ShoppingCart getShoppingCart();
    public int getShoppingCartId(String customer);
    public void addFood(int sCId, int foodId, int quantity);
    public void setDeliveryAddress(int sCId, String city, String street, String zip, String country);
    public void setBillingAddress(int sCId, String city, String street, String zip, String country);
    public void setCustomer(int sCId, String customer);
    public CustomerOrder checkout(int sCId);
}
