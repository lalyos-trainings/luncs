package com.acme.training.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private List<OrderItem> orders;

    public Order(String customer, Address billingAddress, Address deliveryAddress) {
        super();
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.orders = new ArrayList<OrderItem>();
    }

    public Order() {
        super();
        orders = new ArrayList<OrderItem>();
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
    
    public List<OrderItem> getOrders() {
        return orders;
    }
    
    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
    
    public void addOrderItem(OrderItem orderItem){
        orders.add(orderItem);
    }
    
    @Override
    public String toString() {
        String formattedOrder = String
                .format("%s's order\n---------------------------------\nDelivery address:\t%s\nBilling address:\t%s\nOrder items:\n%s",
                        customer, deliveryAddress, billingAddress, orders);
        return formattedOrder;
    }
    
}
