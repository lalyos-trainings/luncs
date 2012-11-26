package com.acme.training.domain;

public class OrderItem {

    private int quant;
    private int id;
    
    public OrderItem ( int id, int quant) {
        this.id=id;
        this.quant=quant;
    }
    
    public String toString () {
        
        return "Food-code: " + id + " , quantity: " + quant;
    }
    
}
