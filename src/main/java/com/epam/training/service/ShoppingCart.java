package com.epam.training.service;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class ShoppingCart {
    private final Order order;
    private final OrderService os;

    public ShoppingCart(String customer, Address billingAddress, Address deliveryAddress, OrderService os) {
        order = new Order(customer, billingAddress, deliveryAddress);
        this.os = os;
    }

    public String getCustomer() {
        return order.getCustomer();
    }

    public Address getBillingAddress() {
        return order.getBillingAddress();
    }

    public Address derliveryAddress() {
        return order.getDeliveryAddress();
    }

    public void addFood(Food food, int quantity) {
        order.getOrderItems().add(new OrderItem(quantity, food));
    }

    public void checkout() {
        os.doOrder(order);
    }
}
