package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    @Autowired
    private RestaurantRepository repo;
    private final PrintWriter writer;
    private ApplicationContext ctx;
    @Value("de")
    private Locale locale;

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }

    public void doList() {
        String nextMsg;
        String foodMsg;

        writer.println(ctx.getMessage("welcome", null, locale));

        for (Restaurant restaurant : repo.getAllRestaurants()) {
            nextMsg = ctx.getMessage("rest.next", null, locale);
            writer.println("=== " + nextMsg + ": " + restaurant.toString());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                foodMsg = ctx.getMessage("food.name", null, locale);
                String format = String.format(foodMsg + ": %-25s [%5d]", food.getName(), food.getPrice());
                writer.println(format);
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

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
