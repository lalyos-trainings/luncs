package com.epam.training.service;

public interface MenuLister {

    public abstract void setRestaurantRepository(RestaurantRepository repo);

    public abstract void doList();

}