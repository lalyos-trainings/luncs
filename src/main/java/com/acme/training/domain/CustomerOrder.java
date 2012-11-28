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
    private final Map<Restaurant, RestaurantOrder> items = new HashMap<Restaurant, RestaurantOrder>();

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress + "]"
                + getFormattedItems();
    }

    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (RestaurantOrder rest : items.values()) {
            for (OrderItem item : rest.getOrderItems()) {
                ret.append(String.format("%n %-25s : %3d", item.getFood()
                                                               .getName(), item.getQuantity()));
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
        int quantity = item.getQuantity();
        RestaurantOrder previousOrder = items.get(food.getRestaurant());
        if (null == previousOrder) {
            RestaurantOrder order = new RestaurantOrder(food.getRestaurant());
            order.addItem(item);
            items.put(food.getRestaurant(), order);
        } else {
            previousOrder.addItem(item);
        }
    }

    public List<OrderItem> getItems() {
        List<OrderItem> ret = new ArrayList(items.values());
        return ret;
    }

    public int getGrandTotal() {
        int total = 0;
        for (RestaurantOrder item : items.values()) {
            total += item.getTotal();
        }

        return total;
    }

    public void printBill() {
        System.out.println("==== Customer Bill");
        System.out.println(customer);
        for (RestaurantOrder order : items.values()) {
            order.printBill();
        }
        System.out.println(String.format("GrandTotal: %-9d", getGrandTotal()));
    }
}
