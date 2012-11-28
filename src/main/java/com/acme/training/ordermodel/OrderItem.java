package com.acme.training.ordermodel;

import com.acme.training.domain.Food;

public class OrderItem {
    private int quantity;
    private Food food;
       
    public OrderItem(int quantity, Food food) {
        super();
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
    
    public int getTotal()  {
        return food.getPrice()*quantity;
    }
    
    public void addQuantity(int additional) {
        this.quantity += additional;
    }
}
