package com.acme.training.domain;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Food { 

    private int id;
    
    public Food() {
        this.id = ID.incrementAndGet();
    }
    
    public Food(String name, int price, Restaurant restaurant) {
        
        this.id = ID.incrementAndGet();
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        
    }

    private String name;
    private String description;
    private int price;
    private Restaurant restaurant;
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    static AtomicInteger ID = new AtomicInteger(0);
    
    public int getId() {
        return id;
    }
    
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", restaurant=" + restaurant + "]";
    }
    
}
