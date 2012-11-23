package com.epam.training.service;

public interface ShoppingCart {
    void addFood(int foodId, int quantity);
    void setCustomer(String customer);
    void setDeliveryAddress(String city, String street, String zip, String country);
    void setBillingaddress(String city, String street, String zip, String country);
    void checkOut();
}
