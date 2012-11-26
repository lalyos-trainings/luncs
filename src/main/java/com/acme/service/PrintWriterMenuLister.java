package com.acme.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {
    
    private RestaurantRepository repo;
    private PrintWriter printWriter;
    
    public PrintWriterMenuLister(PrintWriter printWriter){        
        this.printWriter = printWriter;
    }

    public void setRestaurantRepository(RestaurantRepository repo) {
        this.repo = repo;        
    }

    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            printWriter.println(restaurant);
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
               
                printWriter.println(food);
            }
            
        }
        
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

}
