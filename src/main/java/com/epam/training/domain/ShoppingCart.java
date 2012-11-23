package com.epam.training.domain;

import com.epam.training.service.RestaurantRepository;

public class ShoppingCart {

    private Order order;
    private RestaurantRepository repo;

    public void addFood(int foodId, int quantity) {
        order.addOrderItem(new OrderItem(quantity, foodById(foodId)));
    }

    public void setCustomer(String cust) {
        order.setCustomer(cust);
    }

    private Food foodById(int foodId) {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            for (Food food : restaurant.getMenu().getFoods()) {
                if (food.getID() == foodId) {
                    return food;
                }
            }
        }
        return null;
    }

    public void setBillingAddress(Address billingaddress) {
        order.setBillingAddress(billingaddress);
    }

    public void setDeliveryAddress(Address deliveryaddress) {
        order.setDeliveryAddress(deliveryaddress);
    }

    public void checkout() {

    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

}
