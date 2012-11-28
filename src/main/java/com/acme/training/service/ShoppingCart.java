package com.acme.training.service;

public interface ShoppingCart 
{
    void addFood(int foodId, int quantity);
    
    void setCustomer(String customer);
    
    void setDeliveryAddress(String street, String city, String zip, String country);
    
    void setBillingAddress(String street, String city, String zip, String country);
    
    int checkout();
}
