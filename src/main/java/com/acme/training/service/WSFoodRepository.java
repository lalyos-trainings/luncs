package com.acme.training.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;

@Component
public class WSFoodRepository {

    @Autowired
    Collection<Food> foods;

    public Collection<Food> getFoods() {
        return foods;
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }
    
    public Food getFoodById( int foodId ){
        Food selectedFood = null;
        for ( Food food : foods ){
            if( food.getId().equals( foodId ) ){
                selectedFood = food;
            }
        }
        return selectedFood;
    }
    
}
