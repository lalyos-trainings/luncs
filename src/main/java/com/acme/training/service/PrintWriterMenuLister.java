package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    private PrintWriter writer;
    private RestaurantRepository repo;
    private ApplicationContext context;
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
        System.out.println(context.getMessage("welcome", null, locale));
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== " + context.getMessage("next_restaurant", null, locale) + ": " + restaurant);
        }
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}
