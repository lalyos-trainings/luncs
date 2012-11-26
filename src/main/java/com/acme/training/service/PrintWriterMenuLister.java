package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private PrintWriter writer;
    private RestaurantRepository repo;

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }

    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== next resti: " + restaurant + "\n===");
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                writer.println(food);
            }
        }

        writer.flush();
    }

    public void printOrders(List<Order> orders) {
        for (Order order : orders) {
            writer.println("Customer: " + order.getCustomer());
            writer.println("Delivery address: " + order.getDeliveryAddress());
            writer.println("Billing address: " + order.getDeliveryAddress());
            for (OrderItem orderitem : order.getOrderItems()) {
                writer.println(orderitem.getFood().getName() + ": " + orderitem.getQuantity() + "db");
            }
        }

        writer.flush();
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

}
