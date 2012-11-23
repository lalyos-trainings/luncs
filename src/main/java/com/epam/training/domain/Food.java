package com.epam.training.domain;

public class Food {
    private String name;
    private String description;
    private int price;

    
    public Food() 
    {
        super();
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
    public String toString() 
    {
        return String.format("kajcsi: %-15s ára: %5d YEN", getName(), getPrice());
    }
    
    
}
