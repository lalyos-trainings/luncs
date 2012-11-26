package com.epam.training.domain;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private String customer;
    Address billingAddress;
    Address deliveryAddress;
    List<OrderItem> orderItems;
    
    public Order() {
        orderItems = new LinkedList<OrderItem>();
    }

    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public Address getBillingAddress() {
        return billingAddress;
    }
    
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(int quantity, Food food) {
        orderItems.add(new OrderItem(quantity, food));
    }
    
    
    
    
}
