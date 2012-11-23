package com.epam.training.service;

public class OrderItem {
    
    private int foodId;
    private int count;
    
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    public OrderItem(int foodId, int count) {
        super();
        this.foodId = foodId;
        this.count = count;
    }
    
    public String toString() {
        return String.format("%nfoodid: %d,  count: %d", foodId, count);
    }
    
}
