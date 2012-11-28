package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@WebService
@Component
public class MenuWS {
	
	private List<Food> foods = new ArrayList<Food>();
	@Autowired
	private RestaurantRepository repo;
	
	public MenuWS()
	{

	}

	public List<Food> getFoods()
	{
		return foods;
	}
	
	public void init()
	{
		Collection<Restaurant> restaurants = repo.getAllRestaurants();
		for(Restaurant restaurant : restaurants)
		{
			for (Food food : restaurant.getMenu().getFoods())
				foods.add(food);
		}
	}

}
