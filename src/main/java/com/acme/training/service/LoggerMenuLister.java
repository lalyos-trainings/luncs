package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.domain.Restaurant;

public class LoggerMenuLister implements MenuLister {
    
    private static Logger logger = LoggerFactory.getLogger(LoggerMenuLister.class);
    private RestaurantRepository repo;
    
    /**
     * @see com.acme.training.service.MenuLister#setRepo(com.acme.training.service.RestaurantRepository)
     */
    public void setRepo(RestaurantRepository repo){
        this.repo = repo;
    }
    
    /**
     * @see com.acme.training.service.MenuLister#doList()
     */
    public void doList(){
        for(Restaurant restaurant :  repo.getAllRestaurants()){
            logger.info("==========================");
            logger.info("next resti: {}", restaurant);
        }
    }
    
    public RestaurantRepository getRepo(){
        return repo;
    }
}
