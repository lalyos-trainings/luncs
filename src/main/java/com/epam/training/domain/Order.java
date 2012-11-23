package com.epam.training.domain;

import java.util.List;

public class Order {

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    List<OrderItem> orderItems;

    public Order(String cust, Address billaddress, Address deliveryaddress, List<OrderItem> items) {
        customer = cust;
        billingAddress = billaddress;
        deliveryAddress = deliveryaddress;
        orderItems = items;
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

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }
}
