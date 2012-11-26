package com.epam.training.service;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.domain.Order;

public class InMemoryShoppingcart implements ShoppingCart{
    
    private OrderService os;
    private RestaurantRepository repo;
    private Order order;
    
    public InMemoryShoppingcart() {
        order = new Order();
    }

    
    public void setOs(OrderService os) {
        this.os = os;
    }


    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void addFood(int foodId, int quantity) {
        Food food = repo.getFoodById(foodId);
        order.addOrderItem(quantity, food);        
    }

    public void setCustomer(String customer) {
        order.setCustomer(customer);
        
    }

    public void setDeliveryAddress(String city, String street, String zip, String country) {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void setBillingaddress(String city, String street, String zip, String country) {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void checkOut() {
        os.doOrder(order);
        
    }

}
