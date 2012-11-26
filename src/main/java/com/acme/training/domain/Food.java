package com.acme.training.domain;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Food implements ApplicationContextAware{
    private String name;
    private String description;
    private int price;
    private int id;
    private String foodName_;
    
    public Food() {}
    
    public Food(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
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

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %-15s %5d", foodName_, getName(), getPrice());
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        foodName_ = ctx.getMessage("food.name", null, new Locale("hu"));
        
    }
        
}
