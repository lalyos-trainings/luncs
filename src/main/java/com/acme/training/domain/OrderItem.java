package com.acme.training.domain;

public class OrderItem {
    private int quantity;
    private Food food;
    
    public OrderItem(int quantity, Food food) {
        this.quantity = quantity;
        this.food = food;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Food getFood() {
        return food;
    }
    public void setFoodId(Food food) {
        this.food = food;
    }
    public void addQuantity(int quantity2) {
        this.quantity += quantity2;
    }
    public int getTotal(){
        return food.getPrice() * quantity;
    }
    
}
