package com.acme.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {
    
    @Autowired
    private RestaurantRepository repo;
    private PrintWriter printWriter;
    private ApplicationContext ctx;
    private Locale locale;
    
    public PrintWriterMenuLister(PrintWriter printWriter){        
        this.printWriter = printWriter;
    }

    public void setRestaurantRepository(RestaurantRepository repo) {
        this.repo = repo;        
    }

    public void doList() {
        String message = ctx.getMessage("welcome", null, locale);
        System.out.println(String.format("=== %s ===", message));
        
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            String restName = ctx.getMessage("rest.next", null, locale);
            printWriter.println(String.format("%s %s",restName ,restaurant));
            Collection<Food> foods = restaurant.getMenu().getFoods();
            String foodName = ctx.getMessage("food.name", null, locale);
            for (Food food : foods) {
               
                printWriter.println( String.format("%s %-15s [%5d HUF]",foodName, food.getName(), food.getPrice()));
            }
            
        }
        
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
       this.ctx = ctx;
        
    }

}
