package com.acme.training.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@WebService
@Component
public class MenuWS {
	
	private List<Food> foods;
	@Autowired
	private RestaurantRepository repo;
	private Logger logger = LoggerFactory.getLogger(MenuWS.class);

    public void init() {
    	logger.info("is repo null? " + String.valueOf(repo == null));
    	foods = new ArrayList<Food>();
    	
        for (Restaurant restaurant : repo.getAllRestaurants()) {
        	for (Food food : restaurant.getMenu().getFoods()) {
        		logger.info("food added: " + food.getName());
				foods.add(food);
			}
        }
    }
    
    public MenuWS() {}
    
    @WebMethod
    public List<Food> getFoods() {
        return foods;
    }
}