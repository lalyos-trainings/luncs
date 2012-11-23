package com.epam.training.domain;

import java.util.ArrayList;
import java.util.List;


public class Order 
{
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private List<OrderItem> orderItems;
    
    public Order() 
    {
        this.orderItems = new ArrayList<OrderItem>();
    }

    public void addOrderItem(int quantity, Food food)
    {
        orderItems.add(new OrderItem(quantity, food));
    }
    
    public String getCustomer() 
    {
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
    
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
}
