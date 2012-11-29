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
    private Map<String, RestaurantOrder> restaurantOrders = new HashMap<String, RestaurantOrder>();

    @Override
    public String toString() {
//        return "Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress + "]" + getFormattedItems();
        return printBill();
    }

    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (RestaurantOrder restaurantOrder : restaurantOrders.values()) {
            ret.append(restaurantOrder.getRestaurant().toString());
            for (OrderItem orderItem : restaurantOrder.getOrderItems().values()) {
                ret.append(String.format("%n   %-25s : %3d", orderItem.getFood().getName(), orderItem.getQuantity()));
            }
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

    public void addItem(OrderItem item) {
        Food food = item.getFood();
        String restaurantName = food.getRestaurant().getName();
        RestaurantOrder restaurantOrder = restaurantOrders.get(restaurantName);
        if (restaurantOrder != null) {
            restaurantOrder.addOrderItem(item);
        } else {
            restaurantOrders.put(restaurantName, new RestaurantOrder(item));
        }
    }

    public List<RestaurantOrder> getRestaurantOrders() {
        List<RestaurantOrder> ret = new ArrayList<RestaurantOrder>(restaurantOrders.values());
        return ret;
    }

    public int getTotal() {
        int total = 0;
        for (RestaurantOrder restaurantOrder : restaurantOrders.values()) {
            total += restaurantOrder.getTotal();
        }
        return total;
    }
    
    public String printBill() {
        StringBuffer bill = new StringBuffer();
        bill.append("Customer Order: " + id + "\n");
        bill.append("Customer Name: " + customer + "\n");
        bill.append("Customer Delivery Address: " + deliveryAddress + "\n");
        for (RestaurantOrder restaurantOrder : restaurantOrders.values()) {
            bill.append(restaurantOrder.printBill());
        }
        bill.append("\n===============================================\n");
        bill.append("===== Grand Total: " + String.format("%8d", getTotal()) + " ===================\n");
        bill.append("===============================================\n");
        return bill.toString();
        
    }
}
