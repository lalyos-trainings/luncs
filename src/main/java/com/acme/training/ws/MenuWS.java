package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@WebService
public class MenuWS
{
    private List<Food> foods = new ArrayList<Food>();
    
    
    public MenuWS()
    {
        Restaurant ancsa = new Restaurant("Ancsa", "Futó utca 17", "1082");
        foods.add(new Food(1, "kacsa máj", 1500, ancsa));
        foods.add(new Food(1, "kacsa nyak", 500, ancsa));
    }

    public List<Food> getFoods()
    {
        return foods;
    }

}
