package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class SysoutMenuLister implements MenuLister {

    private RestaurantRepository repo;
    
    /* (non-Javadoc)
     * @see com.epam.training.service.MenuLister#doList()
     */
    public void doList() {
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            System.out.println("=== next resti: " + restaurant.getName());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for (Food food : foods) {
                System.out.println("  " + food.getName());
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
