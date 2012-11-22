package com.epam.training.service;

import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;

public class SystemOutMenuLister implements MenuLister {

	private RestaurantRepository rp;
	
	public void setRestaurantRepository(RestaurantRepository rp) {
		// TODO Auto-generated method stub
		this.rp = rp;
	}

	public void doList() {
		// TODO Auto-generated method stub
		for (Restaurant restaurant : rp.getAllRestaurants())
		{
			System.out.println("==" + restaurant.getName() + "==");
			Collection<Food> foods = restaurant.getMenu().getFoods();
			for (Food food : foods)
			{
				System.out.println("  " + food.getName());
			}
		}
	}

}
