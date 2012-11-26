package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import com.acme.training.domain.Address;

public class Order {
    
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private List<OrderItem> items;
    
    public Order() {
        items = new ArrayList<OrderItem>();
        billingAddress = new Address();
        deliveryAddress = new Address();
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
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    
    public void addOrderItem(OrderItem item) {
        items.add(item);
    }
    
    public String toString() {
        StringBuffer ib = new StringBuffer();
        for (OrderItem i : items) {
            ib.append(String.format("item: %s%n", i));
        }
        return String.format("customer: %s, billing address: %s, delivery address: %s, items: %s",  customer, billingAddress.toString(), deliveryAddress, items);
    }

}
