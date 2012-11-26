package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class PrintWriterMenuLister implements MenuLister {

    private RestaurantRepository repo;
    private PrintWriter printWriter;

    public PrintWriterMenuLister(PrintWriter printWriter){
        this.printWriter = printWriter;
    }
    
    public void setRestaurantRepo(RestaurantRepository repo) {
        this.repo = repo;
    }
    
    public void setRepo(RestaurantRepository repo){
        setRestaurantRepo(repo);
    }

    public void doList() {
        for(Restaurant restaurant :  repo.getAllRestaurants()){
            printWriter.println("============================");
            printWriter.println(restaurant);
            printWriter.println("----------------------------");
            printWriter.println(restaurant.getMenu());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for(Food food : foods){
                printWriter.println(food);
            }
            printWriter.println();
        }
    }

}
