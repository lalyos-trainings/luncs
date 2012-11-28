package com.acme.training.domain;

public class OrderItem {
    private int quantity;
    private Food food;

    public OrderItem(int quantity, Food food) {
        super();
        this.quantity = quantity;
        this.food = food;
    }

    public OrderItem(OrderItem other) {
        super();
        this.quantity = other.quantity;
        this.food = other.food;
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

    public Integer getTotal() {
        return food.getPrice() * quantity;
    }

    public void addQuantity(int additional) {
        this.quantity += additional;
    }

    @Override
    public String toString() {
        return "OrderItem [quantity=" + quantity + ", food=" + food.getName() + "]";
    }

}
