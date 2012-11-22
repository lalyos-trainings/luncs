package com.epam.training;

import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.LoggerMenuLister;
import com.epam.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
      
        //MenuLister lister = new SystemOutMenuLister();
        MenuLister lister = new LoggerMenuLister(); 
        
        lister.setRestaurantRepository(new InMemoryRestaurantRepository());
        lister.doList();

    }

}
