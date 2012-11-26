package com.acme.training.domain;


public class Food {

    private String name;
    private double price;
    private String description;

    public Food(){
        super();
    }
    
    public Food(String name, double price, String description) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
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

    @Override
    public String toString() {
        String formattedFood = String.format("%-20s %7.1f", name, price/*, description*/);
        return formattedFood;
    }
    
    
}
