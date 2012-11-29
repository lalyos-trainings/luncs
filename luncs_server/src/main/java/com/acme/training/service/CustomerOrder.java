package com.acme.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.training.domain.Address;

public class CustomerOrder {

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<Integer, OrderItem> items;

    public CustomerOrder() {
        items = new HashMap<Integer, OrderItem>();
        billingAddress = new Address();
        deliveryAddress = new Address();
    }

    public String getCustomer() {
        return customer;
    }
    
    public RestaurantOrder getRestaurantOrder() {
        return new RestaurantOrder(this);
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
    
    public Collection<OrderItem> getCollection() {
        return items.values();
    }

    public List<OrderItem> getItems() {
        return new ArrayList<OrderItem>(items.values());
    }

    public void addOrderItem(OrderItem item) {
        OrderItem found;
        if ((found = items.get(item.getFoodId())) == null) {
            items.put(item.getFoodId(), item);
        } else {
            found.setCount(found.getCount() + item.getCount());
        }
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", billingAddress=" + billingAddress + ", deliveryAddress="
                + deliveryAddress + ", items=" + items + "]";
    }

}
