package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerOrder {
    
    private static int nextId = 0;
    
    private String id = String.valueOf(nextId++);
    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Map<Restaurant, RestaurantOrder> restaurantOrders = new HashMap<Restaurant, RestaurantOrder>();
    private int total = 0;
    
    public void addOrderItem(OrderItem orderItem) {
        Restaurant restaurant = orderItem.getFood().getRestaurant();
        RestaurantOrder previousOrder = restaurantOrders.get(restaurant);
        if (null == previousOrder) {
            RestaurantOrder restaurantOrder = new RestaurantOrder(restaurant);
            restaurantOrder.addItem(orderItem);
            restaurantOrders.put(restaurant, restaurantOrder);
        } else {
            previousOrder.addItem(orderItem);
        }
        total += orderItem.getTotal();
    }
    
    public RestaurantOrder getRestaurantOrderByRestaurant(Restaurant restaurant) {
        return restaurantOrders.get(restaurant);
    }
    
    public List<RestaurantOrder> getRestaurantOrders() {
        return new ArrayList(restaurantOrders.values());
    }
   
    public String printBill() {
        StringBuffer ret = new StringBuffer();
        for (RestaurantOrder order  : restaurantOrders.values()) {
            ret.append(String.format("%n   %-10s", order.printBill()));
        }
        return ret.toString();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getTotal() {
        return total;
    }
    
    @Override
    public String toString() {
        return "CustomerOrder [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress
                + "]" + printBill() + String.format("%n %n Total bill for customer: %s",getTotal());
    }
}
