package com.acme.training.domain;

public class Food {
    private String name;
    private String description;
    private int price;
    private int foodId;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Food() {}
    
    public Food(String name, int price, int foodId ) {
        this.name = name;
        this.price = price;
        this.foodId=foodId;
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
    
}