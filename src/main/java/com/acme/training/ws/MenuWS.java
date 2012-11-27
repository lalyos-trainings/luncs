package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@WebService
public class MenuWS {

    private final List<Food> foods = new ArrayList<Food>();

    public MenuWS() {
        Restaurant r = new Restaurant("Majcsaws", "Kassai Lajos street", "1111");
        foods.add(new Food(2, "hotdog", 200, r));
        foods.add(new Food(4, "hamburger", 450, r));
    }

    public List<Food> getFoods() {
        return foods;
    }
}
