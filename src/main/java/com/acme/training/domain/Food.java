package com.acme.training.domain;



public class Food {

    private String name;
    private double price;
    private String description;
//    private int id;
    private Restaurant restaurant;
    
//    private static AtomicInteger ID = new AtomicInteger(0);

    public Food(String name, double price, String description, Restaurant restaurant) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
//        id = ID.incrementAndGet();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
//    public int getId(){
//        return id;
//    }
//
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        String formattedFood = String.format(/*"%-2d " + */"%s\n    %-20s %7.1f", /*id, */restaurant.getName(), name, price/*, description*/);
        return formattedFood;
    }
    
    
}
