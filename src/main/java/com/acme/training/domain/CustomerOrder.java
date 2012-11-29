package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerOrder {
    
    public static enum Status { CREATED, REQUEST_SENT_TO_RESTAURANT, DELIVER_ON_WAY_TO_RESTAURANT, DELIVER_ON_WAY_TO_CUSTOMER, PAID
    }
    
    private static int nextId = 0;
    
    private String id = String.valueOf(nextId++);
    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Map<Restaurant, RestaurantOrder> restaurantOrders = new HashMap<Restaurant, RestaurantOrder>();
    private int total = 0;
    private Status status;
    private Date creationTime;
    private Date paymentTime;
     
    
    public CustomerOrder() {
        creationTime = new Date();
        status = Status.CREATED;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }
    
    public void pay() {
        status = Status.PAID;
        paymentTime = new Date();
    }

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
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerOrder [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress
                + ", billingAddress=" + billingAddress + ", total=" + total
                + ", status=" + status + ", creationTime=" + creationTime + ", paymentTime=" + paymentTime + "]"
                + printBill() + String.format("%n %n Total bill for customer: %s", getTotal());
    }

    
}
