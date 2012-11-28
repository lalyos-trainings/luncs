package com.acme.training.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CustomerOrder{

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
//    private Map<Integer, OrderItem> orderItems;
    private Map<Integer, RestaurantOrder> restaurantOrders;
    private double total;
    private int id;

    public CustomerOrder(String customer, Address billingAddress, Address deliveryAddress) {
        super();
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
//        this.orderItems = new HashMap<Integer, OrderItem>();
        restaurantOrders = new HashMap<Integer, RestaurantOrder>();
        total = 0;
    }

    public CustomerOrder() {
        super();
//        orderItems = new HashMap<Integer, OrderItem>();
        restaurantOrders = new HashMap<Integer, RestaurantOrder>();
        total = 0;
    }
    
    public String getCustomer() {
        return customer;
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
    
//    public Map<Integer, OrderItem> getOrderItems() {
//        return orderItems;
//    }
    
    public void addOrderItem(Food food, int quantity){
//        OrderItem tmp = orderItems.get(food.getId());
        RestaurantOrder tmp = restaurantOrders.get(food.getRestaurant().getId()); 
        if(tmp == null){
//            orderItems.put(food.getId(), new OrderItem(quantity, food));
            tmp = new RestaurantOrder();
            tmp.setRestaurant(food.getRestaurant());
            restaurantOrders.put(food.getRestaurant().getId(), tmp);
        }
        tmp.addOrderItem(food, quantity);
        total += (quantity * food.getPrice());
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public Collection<RestaurantOrder> getRestaurantOrders(){
        return restaurantOrders.values();
    }

    @Override
    public String toString() {
//        String orderMessage = applicationContext.getMessage("orderFormat", null, locale);
//        String formattedOrder = String
//                .format(orderMessage,
//                        customer, deliveryAddress, billingAddress, orderItems);
        StringBuilder oi = new StringBuilder();
        for (RestaurantOrder restaurantOrder : restaurantOrders.values()) {
            for (OrderItem item : restaurantOrder.getOrderItems()) {
                oi.append(item);
                oi.append("\n");
            }
        }
        String formattedOrder = String
                .format("%s's order\n---------------------------------\nDelivery address:\t%s\nBilling address:\t%s\nOrder items:\n%s\n----------------\nTotal: %.2f",
                        customer, deliveryAddress, billingAddress, oi.toString(), total);
        return formattedOrder;
    }

}
