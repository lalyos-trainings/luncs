package com.epam.training.domain;

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

    public String toString() {
        StringBuffer foodbuff = new StringBuffer();

        for (Food f : foods) {
            foodbuff.append(String.format("food: %s %n", f));
        }

        return String.format("week: %d, foods:%n %s", week, foodbuff.toString());
    }
}
