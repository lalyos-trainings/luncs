package com.epam.training.domain;

import org.springframework.context.ApplicationContext;

public class Food {

    private String name;
    private String description;
    private int price;
    
    private static ApplicationContext ctx;
    
    public static void setApplicationContext(ApplicationContext ctx)
    {
    	Food.ctx = ctx;
    }

    public static Food getById(String id)
    {
    	return ctx.getBean(id, Food.class);
    }
    
    public Food() {}
    
    public Food(String name, int price) {
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
    

    public String toString(){
        return  String.format("Food: %-15s [%5d]", name, price);
    }
    


}
