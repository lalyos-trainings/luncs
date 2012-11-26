package com.acme.domain;

public class OrderItem {
    private int quantity;
    private Food food;
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }

    public String toString(){
        return String.format("%s, quantity: %d", this.getFood(),this.getQuantity());
    }
}
