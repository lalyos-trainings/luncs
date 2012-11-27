package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;

public interface ShoppingCart {

//    public void setRepo(RestaurantRepository repo);

//    public void addFood(String restiName, String foodName, int count);
//
    public ShoppingCart withFood(String foodName, int count);

    public ShoppingCart withCustomer(String name);

    public ShoppingCart withDeliveryAddress(Address address);

    public ShoppingCart withBillingAddress(Address address);

    public Order checkOut();
    
}