package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Menu {
    
    private Collection<Food> foods = new ArrayList<Food>();
    private int week;

    public Collection<Food> getFoods() {
        return foods;
    }
    
    public Food getFood(int index) {
        return (Food) foods.toArray()[index];
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (Food f : foods) {
            buff.append( String.format("<id: %d, name: %s, price: %d>", f.getId(), f.getName(), f.getPrice() ));
        }
        return buff.toString();
    }

}
