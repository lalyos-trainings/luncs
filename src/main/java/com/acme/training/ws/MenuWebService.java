package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@WebService
@Component
public class MenuWebService {
    
    private List<Food> foods = new ArrayList<Food>(); 
    @Autowired
    private RestaurantRepository repo;
    
    public void init(){
        Collection<Restaurant> allRestaurants = repo.getAllRestaurants();
        for (Restaurant restaurant : allRestaurants) {
            Collection<Food> foods2 = restaurant.getMenu().getFoods();
            for (Food food : foods2) {
                foods.add(food);
            }
        }
    }
    
    public List<Food> getFoods(){
        return foods;
    }
}
