package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    private PrintWriter writer;
    private RestaurantRepository repo;
    private ApplicationContext ctx;
    private Locale locale;
    private Logger logger = LoggerFactory.getLogger(PrintWriterMenuLister.class);
    
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
        String msg = ctx.getMessage("welcome", null, locale);
        writer.println(String.format("=== %s ===", msg));

        logger.info("locale: " + locale);
        String nextRestMsg = ctx.getMessage("rest.next", null, locale);
        String foodName = ctx.getMessage("food.name", null, locale);
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            
            writer.println("=== " + nextRestMsg + ": " + restaurant + "\n===");
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                writer.println(String.format("%s: %-15s [%5d]",foodName , food.getName(), food.getPrice()));
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

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }


}
