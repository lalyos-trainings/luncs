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
    private Map<String, RestaurantOrder> restaurantOrderMap = new HashMap<String, RestaurantOrder>(); 
    
    public Map<String, RestaurantOrder> getRestaurantOrderMap() {
        return restaurantOrderMap;
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
    
    public void addItem(OrderItem item) {
        // We push the item to the corresponding RestaurantOrder in our map
        String restaurantId = item.getFood().getRestaurant().getId();
        RestaurantOrder restaurantOrder = restaurantOrderMap.get(restaurantId);
        if (restaurantOrder == null) {
            RestaurantOrder nextRO = new RestaurantOrder();
            nextRO.setRestaurant(item.getFood().getRestaurant());
            nextRO.addItem(item);
            restaurantOrderMap.put(restaurantId, nextRO);
        } else {
            restaurantOrder.addItem(item);
        }         
    }
    public int getTotal() {
        int total  = 0;
        for (RestaurantOrder item : restaurantOrderMap.values()) {
            total += item.getTotal();
        }
        
        return total;
    }
    
    public void printBill() {
        System.out.println("Bill for " + customer);
        for (RestaurantOrder item : restaurantOrderMap.values()) {
            item.printBill();
        }
        System.out.println("--------------------------------------------");
        System.out.println(String.format("%s %37d","TOTAL:", getTotal()));
        
    }
    
    public List<OrderItem> getItems() {
        List<OrderItem> ret = new ArrayList<OrderItem>();
        for (RestaurantOrder item : restaurantOrderMap.values()) {
            ret.addAll(item.getOrderItems());
        }
        return ret;
    }
    
    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress
                + "]";
    }

}
