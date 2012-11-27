package com.acme.training.domain;

public class OrderItem {
    
    private int quantity;
    private Food food;
    
    public OrderItem() {
        super();
    }

    public OrderItem(int quantity, Food food) {
        super();
        this.quantity = quantity;
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    @Override
    public String toString(){
        String formattedOrderItem = String.format("%-2d db %s", quantity, food.getName());
        return formattedOrderItem;
    }

}
