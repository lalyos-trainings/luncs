package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.service.InMemoryStatisticService;

public class CustomerOrder {

    private static int nextId = 0;

    private int id = nextId++;

    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Map<Integer, RestaurantOrder> orderMap = new HashMap<Integer, RestaurantOrder>();
    private Logger logger = LoggerFactory.getLogger(InMemoryStatisticService.class);

    public String printBill() {
        return "Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress + "]\n"
                + getFormattedItems();
    }

    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (RestaurantOrder restaurantOrder : orderMap.values()) {
            // ret.append(String.format("%n   %-25s : %3d",
            // item.getFood().getName(), item.getQuantity()));
            ret.append(restaurantOrder.printBill() + "\n");
        }
        return ret.toString();
    }

    public void addItem(OrderItem item) {
        Food food = item.getFood();
        for (RestaurantOrder restOrder : orderMap.values()) {
            if (restOrder.getRestaurant().getName() == food.getRestaurant().getName()) {
                restOrder.addItem(item);
                return;
            }
        }
        RestaurantOrder restaurantOrder = new RestaurantOrder(item);
        orderMap.put(restaurantOrder.getId(), restaurantOrder);
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

    public int getId() {
        return id;
    }

    public int getTotal() {
        int total = 0;
        for (RestaurantOrder restOrder : orderMap.values()) {
            total += restOrder.getTotal();
        }
        return total;
    }

    public List<RestaurantOrder> getRestaurantOrders() {
        List<RestaurantOrder> ret = new ArrayList(orderMap.values());
        return ret;
    }
}
