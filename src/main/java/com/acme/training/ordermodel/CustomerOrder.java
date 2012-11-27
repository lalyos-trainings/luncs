package com.acme.training.ordermodel;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@SuppressWarnings("unused")
public class CustomerOrder {
    private static int nextId = 0;
    private String id = String.valueOf(nextId++);

    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Map<String, RestaurantOrder> restOrders;

    public CustomerOrder() {
        this.restOrders = new HashMap<String, RestaurantOrder>();
    }

    public CustomerOrder(String customer, Address deliveryAddress, Address billingAddress) {
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.restOrders = new HashMap<String, RestaurantOrder>();
    }

    public String getCustomer() {
        return customer;
    }

    public Map<String, RestaurantOrder> getRestaurantOrders() {
        return restOrders;
    }

    public int getTotal() {
        int fullTotal = 0;
        for (RestaurantOrder order : restOrders.values()) {
            fullTotal += order.getTotal();
        }
        return fullTotal;
    }

    public void printBill() {
        int fullTotal = 0;
        for (RestaurantOrder order : restOrders.values()) {
            fullTotal += order.getTotal();
            order.printBill();
        }
        System.out.println("********** Final bill full total: " + Integer.toString(fullTotal));
    }

    // public Address getDeliveryAddress() {
    // return deliveryAddress;
    // }
    //
    // public Address getBillingAddress() {
    // return billingAddress;
    // }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addItem(OrderItem item) {
        Food food = item.getFood();
        Restaurant current = food.getRestaurant();

        if (!restOrders.containsKey(current.getName())) {
            RestaurantOrder order = new RestaurantOrder(current);
            order.addItem(item);
            restOrders.put(current.getName(), order);
        } else {
            RestaurantOrder order = restOrders.get(current.getName());
            restOrders.remove(current.getName());
            order.addItem(item);
            restOrders.put(current.getName(), order);
        }
    }
}
