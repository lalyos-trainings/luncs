package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class MenuWS {

    private List<Food> foods = new ArrayList<Food>();
    
    public MenuWS() {
        Restaurant ancsa = new Restaurant("Ancsa", "Futo utca 10", "1082");
        foods.add(new Food("babgulyas", 750, ancsa));
        foods.add(new Food("palacsinta", 320, ancsa));        
    }
    
    public List<Food> getFoods() {
        return foods;
    }
}
