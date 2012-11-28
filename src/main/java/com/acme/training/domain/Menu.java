package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Menu {
    private Collection<Food> foods = new ArrayList<Food>();
    private int week;

    public Collection<Food> getFoods() {
        return foods;
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
}
