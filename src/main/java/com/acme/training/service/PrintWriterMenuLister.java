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

    private final PrintWriter writer;
    private RestaurantRepository repo;
    private ApplicationContext ctx;

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }

    public void doList() {
        String nextMsg;
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            nextMsg = ctx.getMessage("rest.next", null, new Locale("hu"));
            writer.println("=== " + nextMsg + ": " + restaurant.toString());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                String format = String.format("Food: %-25s [%5d]", food.getName(), food.getPrice());
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
}
