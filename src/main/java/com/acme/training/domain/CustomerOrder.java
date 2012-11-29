package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class CustomerOrder {
    private static int nextId = 0;
    
    private String id = String.valueOf(nextId++);
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();
    private String customer;
    private Address deliveryAddress;
    
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    private Address billingAddress;
    private Map<String, RestaurantOrder> restaurantOrders;
    
    
    public List<OrderItem> getOrderItemsList () {
        return this.orderItemList;
    }

    public CustomerOrder() {
        this.restaurantOrders = new HashMap<String, RestaurantOrder>();
    }

    public String getCustomer() {
        return customer;
    }

    public Map<String, RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }

    public int getTotal() {
        
        int price = 0;
        for (RestaurantOrder order : restaurantOrders.values()) {
            price += order.getTotal();
        }
        return price;
    }

    public void printBill() {
        
        System.out.println("Bill of " +customer);
        int price = 0;
        for (RestaurantOrder order : restaurantOrders.values()) {
            price += order.getTotal();
            order.printBill();
        }
        System.out.println("Full total of " + customer + "'s order: " + Integer.toString(price));
    }

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
        
        orderItemList.add(item);
        
        Food food = item.getFood();
        Restaurant resti = food.getRestaurant();

        if ( ! restaurantOrders.containsKey(resti.getName())) {
            RestaurantOrder order = new RestaurantOrder(resti);
            order.addItem(item);
            restaurantOrders.put(resti.getName(), order);
        } else {
            RestaurantOrder order = restaurantOrders.get(resti.getName());
            restaurantOrders.remove(resti.getName());
            order.addItem(item);
            restaurantOrders.put(resti.getName(), order);
        }
    }
}