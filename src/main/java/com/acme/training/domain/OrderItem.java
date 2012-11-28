package com.acme.training.domain;

public class OrderItem {
    private int quantity;
    private Food food;
    private int total;
    
    public OrderItem(int quantity, Food food) {
        super();
        this.quantity = quantity;
        this.food = food;
        calculateTotal();
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public Food getFood() {
        return food;
    }
    
    public void addQuantity(int additional) {
        this.quantity += additional;
    }
    
    public int getTotal(){
        return total;
    }
    
    private void calculateTotal(){
        this.total = this.quantity * food.getPrice();
    }
}
