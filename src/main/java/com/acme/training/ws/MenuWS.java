package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@Component
@WebService
public class MenuWS {

    private RestaurantRepository repo;
    private List<Food> food = new ArrayList<Food>();
    
    public MenuWS(){
        Restaurant resti = new Restaurant("Ancsa", "Futó utca", "1082");
        food.add(new Food("babgulyás", 850, "Babgulyás magyarosan.", resti));
        food.add(new Food("palacsinta", 250, "Palacsinta választható töltelékkel.", resti));
    }
    
    public List<Food> getFood(){
        return food;
    }
}
