package com.acme.training.service;

public interface ShoppingCart {
    void addFood(int foodId, int quantity);
    void setCustomer(String customer);
    String getCustomer();
    int getCartId();
    void setDeliveryAddress(String city, String street, String zip, String country);
    void setBillingaddress(String city, String street, String zip, String country);
    int checkOut();
}
