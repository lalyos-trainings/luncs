package com.acme.training.domain;

public class Food {
    private String name;
    private String description;
    private int price;
    private int id;
    
    public Food() {}
    
    public Food(int id, String name, int price) {
        this.id = id;
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

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-15s %5d", getName(), getPrice());
    }
        
}
