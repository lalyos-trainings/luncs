package com.acme.training.service;

import java.util.Collection;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import com.acme.training.App;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class LogMenuLister implements MenuLister {

	private RestaurantRepository rp;
	private static Logger logger = LoggerFactory.getLogger(App.class);
	
	public void setRestaurantRepository(RestaurantRepository rp) {
		// TODO Auto-generated method stub
		this.rp = rp;
	}

	public void doList() {
		// TODO Auto-generated method stub
		for (Restaurant restaurant : rp.getAllRestaurants())
		{
			logger.info("==" + restaurant.getName() + "==");
			Collection<Food> foods = restaurant.getMenu().getFoods();
			for (Food food : foods)
			{
				logger.info("  " + food.getName());
			}
		}
	}

	
	
}
