package com.acme.training.domain;


public class Food
{
    private int id;
    private String name;
    private String description;
    private int price;
    private Restaurant restaurant;

    
    public Food() 
    {
        super();
    }
    
    public Food(int id, String name, int price, Restaurant restaurant) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
    
    public Restaurant getRestaurant()
    {
        return restaurant;
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

    @Override
    public String toString() 
    {
        return String.format("Food: %-15s %5d YEN", getName(), getPrice());
    }
    
}
