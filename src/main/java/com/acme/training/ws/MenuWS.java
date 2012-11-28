package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.RestaurantRepository;

@Component
@WebService
public class MenuWS
{
    @Autowired
    private RestaurantRepository repo;
    private List<Food> foods = new ArrayList<Food>();
    
    
    public MenuWS()
    {
        
    }
    
    public void init()
    {
        Iterator<Restaurant> iterator = repo.getAllRestaurants().iterator();
        while (iterator.hasNext() == true)
        {
            Restaurant restaurant = iterator.next();
            Menu menu = restaurant.getMenu();
            foods.addAll(menu.getFoods());
        }
    }

    public List<Food> getFoods()
    {
        return foods;
    }

}
