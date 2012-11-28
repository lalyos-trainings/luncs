package com.acme.domain;


public class Food{
    private int id;
    private String name;
    private String description;
    private int price;
    private Restaurant restaurant;

    public Food(){}
    
    public Food(String name, int price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
    
    public Food(int id, String name, int price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        
        return  String.format("Food %-15s [%5d HUF]", this.getName(), this.getPrice());
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

}
