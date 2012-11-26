package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;

public interface ShoppingCart {

    public void setRepo(RestaurantRepository repo);

//    public void addFood(String restiName, String foodName, int count);
//
    public void addFood(String foodName, int count);

    public void setCustomer(String name);

    public void setDeliveryAddress(Address address);

    public void setBillingAddress(Address address);

    public Order checkOut();

}