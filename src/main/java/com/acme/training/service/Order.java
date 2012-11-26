package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.acme.training.domain.Address;

public class Order {
    
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<Integer, OrderItem> items;
    
    public Order() {
        items = new HashMap<Integer, OrderItem>();
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
        return new ArrayList<OrderItem>(items.values());
    }
    
    public void addOrderItem(OrderItem item) {
        OrderItem found;
        if ( (found = items.get(item.getFoodId())) == null ) {
            items.put(item.getFoodId(), item);
        } else {
            found.setCount( found.getCount() + item.getCount() );
        }
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", billingAddress=" + billingAddress + ", deliveryAddress="
                + deliveryAddress + ", items=" + items + "]";
    }
    
}
