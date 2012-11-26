package com.acme.service;

import com.acme.domain.Address;

public interface ShoppingCart {

    public abstract void addFood(int foodId, int quantity);

    public abstract void setCustomer(String customer);

    public abstract void setDeliveryAddress(Address address);

    public abstract void setBillingAddress(Address address);
    
    public void checkout();

}