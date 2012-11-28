package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerOrder {

    private static int nextId = 0;

    private String id = String.valueOf(nextId++);
    private String customer;
    private Address deliveryAddress;
    private Collection<RestaurantOrder> restaurentOrders;

    /**
     * @param customer
     * @param deliveryAddress
     * @param restaurentOrders
     */
    public CustomerOrder(String customer, Address deliveryAddress, Collection<RestaurantOrder> restaurentOrders) {
        super();
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.restaurentOrders = restaurentOrders;
    }

    public CustomerOrder() {

    }

    public void addItem(OrderItem orderItem) {

        if (!isAddedToExistingRestaurantOrder(orderItem)) {
            ArrayList<OrderItem> initOrderItems = new ArrayList<OrderItem>();
            initOrderItems.add(orderItem);
            restaurentOrders.add(new RestaurantOrder(orderItem.getFood().getRestaurant(), initOrderItems));
        }

    }

    private boolean isAddedToExistingRestaurantOrder(OrderItem orderItem) {
        boolean result = false;
        if (restaurentOrders != null) {
            for (RestaurantOrder nextResOrder : restaurentOrders) {
                if (isSameRestaurant(orderItem, nextResOrder)) {
                    nextResOrder.getOrderItems().add(orderItem);
                    result = true;
                }
            }
        } else {
            restaurentOrders = new ArrayList<RestaurantOrder>();
        }
        return result;
    }

    private boolean isSameRestaurant(OrderItem orderItem, RestaurantOrder nextResOrder) {
        boolean result = false;
        if (nextResOrder.getRestaurant().getName().equals(orderItem.getFood().getRestaurant().getName())) {
            result = true;
        }
        return result;
    }

    public Integer getTotal() {
        Integer result = 0;
        for (RestaurantOrder nextRestOrder : restaurentOrders) {
            result += nextRestOrder.getTotal();
        }
        return result;

    }

    public void printBill() {
        for (RestaurantOrder nextRestaurentOrders : restaurentOrders) {
            System.out.println(nextRestaurentOrders);
        }
    }

    public Collection<RestaurantOrder> getRestaurentOrders() {
        return restaurentOrders;
    }

    public void setRestaurentOrders(Collection<RestaurantOrder> restaurentOrders) {
        this.restaurentOrders = restaurentOrders;
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

    public Collection<RestaurantOrder> getRestaurantOrders() {
        return restaurentOrders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
