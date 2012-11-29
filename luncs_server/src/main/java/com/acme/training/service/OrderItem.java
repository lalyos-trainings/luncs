package com.acme.training.service;

import com.acme.training.domain.Food;

public class OrderItem {
    
    private Food food;
    private int count;
    
    public OrderItem() {}
    
    public Food getFood() {
        return food;
    }
    
    public int getFoodId() {
        return food.getId();
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    public OrderItem(Food food, int count) {
        super();
        this.food = food;
        this.count = count;
    }
    
    public String toString() {
        return String.format("%nfood: %s, count: %d", food, count);
    }
    
}
