package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@WebService
public class MenuWebService {
    
    private List<Food> foods; 
    
    public MenuWebService(){
        foods = new ArrayList<Food>();        
        Restaurant ancsa = new Restaurant("Ancsa", "kuki street", "1054");
        foods.add(new Food(0, "gulyas", 500, ancsa));
        foods.add(new Food(1, "bableves", 500, ancsa));        
    }
    
    public List<Food> getFoods(){
        return foods;
    }
}
