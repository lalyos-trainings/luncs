package com.acme.training.domain;

public class OrderItem {
    private int quantity;
    private Food food;
    
    public OrderItem (Food food, int q){
            this.food = food;
            quantity=q;
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
    
    public String toString(){
        
        return food + ", mennyiseg: " + quantity; 
    }
   
}
