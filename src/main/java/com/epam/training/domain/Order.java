package com.epam.training.domain;

import java.util.Collection;

public class Order {
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Collection<OrderItem> orderItems;
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
    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
