package com.acme.training.domain;

import java.util.concurrent.atomic.AtomicInteger;


public class Food {

    private String name;
    private double price;
    private String description;
    private int id;
    
    private static AtomicInteger ID = new AtomicInteger(0);

    public Food(){
        super();
        id = ID.incrementAndGet();
    }
    
    public Food(String name, double price, String description) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        id = ID.incrementAndGet();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        String formattedFood = String.format("%-2d %-20s %7.1f", id, name, price/*, description*/);
        return formattedFood;
    }
    
    
}
