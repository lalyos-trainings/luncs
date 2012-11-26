package com.acme.training.domain;

import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Menu implements ApplicationContextAware{
    
    private Collection<Food> foods;
    private int week;
    private ApplicationContext applicationContext;

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
        String menuMessage = applicationContext.getMessage("menuFormat", null, new Locale("hu"));
        String formattedMenu = String.format(menuMessage, week);
        return formattedMenu;
    }
    
    public void addFood(Food food){
        if(foods != null){
            foods.add(food);
        }
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

}
