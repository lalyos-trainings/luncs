package com.epam.training.service;

import com.epam.training.domain.Address;

public class ShoppingCart {
    
    private Order order;
    
    public ShoppingCart() {
        order = new Order();
    }
    
    public void addFood(int foodId, int count) {
        OrderItem item = new OrderItem(foodId, count);
        order.addOrderItem(item);
    }
    
    public void setCustomer(String customer) {
        order.setCustomer(customer);
    }
    
    public void setDeliveryAddress(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
    }
    
    public void setBillingAddress(Address billingAddress) {
        order.setBillingAddress(billingAddress);
    }
    
    public Order checkout() {
        return order;
    }
    
}
