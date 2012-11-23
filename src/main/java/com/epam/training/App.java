package com.epam.training;

import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.RestaurantRepository;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RestaurantRepository repo = new InMemoryRestaurantRepository();
        SysoutMenuLister lister = new SysoutMenuLister();
        lister.setRepo(repo);

        lister.doList();

    }

}
