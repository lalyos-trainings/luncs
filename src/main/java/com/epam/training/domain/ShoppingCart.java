package com.epam.training.domain;

import com.epam.training.service.OrderService;
import com.epam.training.service.RestaurantRepository;

public class ShoppingCart {

    private Order order = new Order();
    private RestaurantRepository repo;
    private OrderService orderservice;

    public void addFood(int foodId, int quantity) {
        order.addOrderItem(new OrderItem(quantity, foodById(foodId)));
    }

    public void setCustomer(String cust) {
        order.setCustomer(cust);
    }

    public Food foodById(int foodId) {
        System.out.println("NEM MEGY");
        Food tempfood = new Food();
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            for (Food food : restaurant.getMenu().getFoods()) {
                if (food.getID() == foodId) {
                    return food;
                }
            }
        }

        return tempfood;
    }

    public void setBillingAddress(Address billingaddress) {
        order.setBillingAddress(billingaddress);
    }

    public void setDeliveryAddress(Address deliveryaddress) {
        order.setDeliveryAddress(deliveryaddress);
    }

    public void checkout() {
        orderservice.doOrder(order);
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public OrderService getOrderservice() {
        return orderservice;
    }

    public void setOrderservice(OrderService orderservice) {
        this.orderservice = orderservice;
    }

}
