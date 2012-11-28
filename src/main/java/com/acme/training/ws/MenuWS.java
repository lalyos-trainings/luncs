package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@WebService
@Component

public class MenuWS {

    @Autowired
    private RestaurantRepository repo;
    private List<Food> foods = new ArrayList<Food>();
    
    public void init() {
        
        Collection<Restaurant> restaurants = repo.getAllRestaurants();
        for ( Restaurant restaurant : restaurants) {
            Collection<Food> foods2 = restaurant.getMenu().getFoods();
            for ( Food food : foods2) {
                foods.add(food);
            }
        }
        
    }
    
    
    
    public MenuWS(){
        
    /*    Restaurant ancsa = new Restaurant("Ancsa", "Futo utca 10", "1082");
        foods.add(new Food("babgulyas", 750, ancsa));
        foods.add(new Food("palacsinta", 320, ancsa));  */
    }

    public List<Food> getFoods() {
        
        return foods;
    }


}
