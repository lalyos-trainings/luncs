package com.acme.training.domain;


public class OrderItem 
{
    private int quantity;
    private Food food;
    
    public OrderItem(int quantity, Food food) 
    {
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
    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() 
    {
        return String.format("%s, %d db",  food, quantity);
    }

    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }
    
}
