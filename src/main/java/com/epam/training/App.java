package com.epam.training;

import java.io.PrintWriter;

import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.MenuLister;
import com.epam.training.service.PrintWriterMenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
      
        //MenuLister lister = new SystemOutMenuLister();
        MenuLister lister = new PrintWriterMenuLister(new PrintWriter(System.out,true)); 
        
        lister.setRestaurantRepository(new InMemoryRestaurantRepository());
        lister.doList();

    }

}
