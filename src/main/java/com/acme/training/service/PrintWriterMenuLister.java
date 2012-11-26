package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    private PrintWriter writer;
    private RestaurantRepository repo;
    private ApplicationContext context;
    private Locale locale;
    
    
    public Locale getLocale()
    {
        return locale;
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
    }

    public PrintWriterMenuLister(PrintWriter writer) 
    {
        this.writer = writer;
    }
    
    public void doList() 
    {
        String nextRestMessage = context.getMessage("rest.next", null, locale);
        String foodName = context.getMessage("food.name", null, locale);
        String message = context.getMessage("welcome", null, locale);
        
        writer.println(String.format("=== %s ===", message));
        
        for (Restaurant restaurant : repo.getAllRestaurants()) 
        {
            writer.println("==== " + nextRestMessage + ": " + restaurant);
            Collection<Food> foods = restaurant.getMenu().getFoods();
           
            for (Food food : foods) 
            {
                writer.println(String.format("%s: %-15s %5d YEN", foodName, food.getName(), food.getPrice()));
            }
        }
        
        writer.flush();
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException
    {
        this.context = context;
    }


}
