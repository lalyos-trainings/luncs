package com.epam.training.service;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class ShoppingCart {

    private OrderService orderService;
    private RestaurantRepository repo;    
    private Order order;

    private ShoppingCart() {
        this.order = new Order();
    }
    
    public ShoppingCart withCustomer(String customer) {
        order.setCustomer(customer);
        return this;
    }
    
    public ShoppingCart withDeliveryAddress(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
        return this;
    }

    public ShoppingCart withBillingAddress(Address billingAddress) {
        order.setBillingAddress(billingAddress);
        return this;
    }

    public ShoppingCart withFood(int id) {
        return withFood(id, 1);
    }

    public ShoppingCart withFood(int id, int quantity) {
        Food food = repo.findFoodById(id);
        order.addItem(new OrderItem(quantity, food));
        return this;
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void checkout() {
        orderService.doOrder(order);
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

}
