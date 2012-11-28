package com.acme.domain;

public class OrderItem {
    private int quantity;
    private Food food;
    
    public OrderItem(Food food, int quantity){
        super();
        this.food = food;
        this.quantity = quantity;
    }
    
    public OrderItem(OrderItem item){        
        super();
        this.food = item.food;
        this.quantity = item.quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
  
    public Food getFood() {
        return food;
    }

    public String toString(){
        return String.format("%s, quantity: %d", this.getFood(),this.getQuantity());
    }
    
    public void addQuantity(int quantity){
        this.quantity+=quantity;
    }
}
