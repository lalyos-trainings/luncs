package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;

public interface ShoppingCart {

//    public void setRepo(RestaurantRepository repo);

    public ShoppingCart withFood(String restiName, String foodName, int count);

    public ShoppingCart withFood(int foodId, int count);

    public ShoppingCart withCustomer(String name);

    public ShoppingCart withDeliveryAddress(Address address);

    public ShoppingCart withBillingAddress(Address address);

    public CustomerOrder checkOut();
    
    public int getId();
    
}