package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.training.domain.Restaurant;

public class LoggerMenuLister implements MenuLister {
    
    private static Logger logger = LoggerFactory.getLogger(LoggerMenuLister.class);
    private RestaurantRepository repo;
    
    /**
     * @see com.acme.training.service.MenuLister#setRestaurantRepo(com.acme.training.service.RestaurantRepository)
     */
    public void setRestaurantRepo(RestaurantRepository repo){
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
    
    public void setRepo(RestaurantRepository repo){
        setRestaurantRepo(repo);
    }
    
    public RestaurantRepository getRepo(){
        return repo;
    }
}
