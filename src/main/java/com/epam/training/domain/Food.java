package com.epam.training.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Food {
    int id;

    private String name;
    private String description;
    private int price;
    
    static AtomicInteger ID = new AtomicInteger(0);
    
    public int getId() {
        return id;
    }
    
    public Food() {
        id = ID.incrementAndGet();
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
        return String.format("(%d) name: %-20s, price: %-5d", id, name, price);
    }
    
}
