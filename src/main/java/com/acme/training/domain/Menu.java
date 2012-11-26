package com.acme.training.domain;

import java.util.Collection;

public class Menu {
    
    private Collection<Food> foods;
    private int week;

    public Menu(Collection<Food> foods, int week) {
        super();
        this.foods = foods;
        this.week = week;
    }

    public Menu() {
        super();
    }

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

    @Override
    public String toString() {
//        String foodString = "";
//        for(Food food : foods){
//            foodString += food + "\n";
//        }
//        return "Menu [foods=" + foods + ", week=" + week + "]";
        return week + ". heti menü:\n"/* + "\n" + foodString*/;
    }
    
    public void addFood(Food food){
        if(foods != null){
            foods.add(food);
        }
    }

}
