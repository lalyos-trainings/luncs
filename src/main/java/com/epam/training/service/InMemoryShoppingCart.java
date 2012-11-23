package com.epam.training.service;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.domain.Order;

public class InMemoryShoppingCart implements ShoppingCart 
{
    private Order order;
    private OrderService orderService;
    private RestaurantRepository repository;

    public InMemoryShoppingCart() 
    {
        order = new Order();
    }

    public void setOrderService(OrderService orderService) 
    {
        this.orderService = orderService;
    }

    public void setRepository(RestaurantRepository repository) 
    {
        this.repository = repository;
    }

    public void addFood(int foodId, int quantity) 
    {
        Food food = repository.getFoodById(foodId);
        order.addOrderItem(quantity, food);
    }

    public void setCustomer(String customer) 
    {
        order.setCustomer(customer);
    }

    public void setDeliveryAddress(String street, String city, String zip, String country) 
    {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void setBillingAddress(String street, String city, String zip, String country) 
    {
        order.setBillingAddress(new Address(street, city, zip, country));
    }

    public void checkout() 
    {
        orderService.doOrder(order);
    }
    
}
