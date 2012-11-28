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
import com.acme.training.repository.RestaurantRepository;

@WebService
@Component
public class MenuWS {

    private List<Food> foods = new ArrayList<Food>();
    @Autowired
    private RestaurantRepository repo;

    public MenuWS() {
    }
    
    @WebMethod(exclude=true)
    public void init(){
        Collection<Restaurant> rests = repo.getAllRestaurants();
        for (Restaurant rest : rests) {
            Collection<Food> f=rest.getMenu().getFoods();
            for (Food food : f) {
                foods.add(food);
            }
        }
    }

    @WebMethod
    public List<Food> getFood() {
        return foods;
    }
}
