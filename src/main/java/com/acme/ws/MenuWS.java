package com.acme.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.domain.Food;
import com.acme.domain.Restaurant;
import com.acme.service.RestaurantRepository;

@Component
@WebService
public class MenuWS {

    @Autowired
    private RestaurantRepository repo;
    private List<Food> foods = new ArrayList<Food>();
    public MenuWS(){   
    }
    
    public void init(){
        Collection<Restaurant> rests = repo.getAllRestaurants();
        for (Restaurant restaurant : rests) {
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
