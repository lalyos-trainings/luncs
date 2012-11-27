package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    private PrintWriter writer;
    
    @Autowired
    @Qualifier("xml")
    private RestaurantRepository repo;
    private ApplicationContext ctx;
    @Value("${language}")
    private Locale locale;   
    
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void doList() {
        String welcomeMsg = ctx.getMessage("welcome",null,locale);
        String nextRestMsg = ctx.getMessage("rest.next",null,locale);
        String foodName = ctx.getMessage("food.name", null, locale);
        writer.println("=======" + welcomeMsg + "=======");
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== " + nextRestMsg + " resti: " + restaurant);
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                writer.println(String.format("%s: %s %-15s", foodName, food.getName(), food.getPrice()));            
            }
        }

        writer.flush();
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
        
    }


}
