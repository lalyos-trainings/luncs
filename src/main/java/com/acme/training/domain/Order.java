package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;


public class Order{

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<String, OrderItem> orderItems;

    public Order(String customer, Address billingAddress, Address deliveryAddress) {
        super();
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.orderItems = new HashMap<String, OrderItem>();
    }

    public Order() {
        super();
        orderItems = new HashMap<String, OrderItem>();
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
    
    public Map<String, OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(Food food, int quantity){
        OrderItem tmp = orderItems.get(food.getName());
        if(tmp == null){
            orderItems.put(food.getName(), new OrderItem(quantity, food));
        }
        else{
            tmp.setQuantity(tmp.getQuantity() + quantity);
        }
    }
    
    public void setOrderItems(Map<String, OrderItem> orders) {
        this.orderItems = orders;
    }
    
    @Override
    public String toString() {
//        String orderMessage = applicationContext.getMessage("orderFormat", null, locale);
//        String formattedOrder = String
//                .format(orderMessage,
//                        customer, deliveryAddress, billingAddress, orderItems);
        String formattedOrder = String
        .format("%s's order\n---------------------------------\nDelivery address:\t%s\nBilling address:\t%s\nOrder items:\n%s",
                customer, deliveryAddress, billingAddress, orderItems);
        return formattedOrder;
    }

}
