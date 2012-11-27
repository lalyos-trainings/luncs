package com.acme.training.domain;

public class Food {
    private String name;
    private String description;
    private int price;
    private Integer id;
    private Restaurant restaurant;
    
    public Food(String name, int price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String toString(){
        return  String.format("Food: %-15s [%5d]", name, price);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
}
