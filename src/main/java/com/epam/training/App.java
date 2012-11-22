package com.epam.training;

import java.util.Collection;

import com.epam.training.domain.Food;
import com.epam.training.domain.Restaurant;
import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.RestaurantRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RestaurantRepository repo = new InMemoryRestaurantRepository();
        for(Restaurant restaurant :  repo.getAllRestaurants()){
            System.out.println("==========================");
            System.out.println("next resti: " + restaurant);
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for(Food food : foods){
                System.out.println("next food: " + food);
            }
        }
    }
}
