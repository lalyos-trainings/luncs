package com.epam.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.epam.training.domain.Food;
import com.epam.training.domain.Menu;
import com.epam.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    
    public InMemoryRestaurantRepository() {
        addRestaurant(createResti1());
        addRestaurant(createResti2());        
    }
        
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food(1, "pacal", 500));
        m1.getFoods().add(new Food(2, "toltott kaposzta",750));
        m1.getFoods().add(new Food(3, "bableves", 690));
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food(4, "lencse leves", 400));
        m1.getFoods().add(new Food(5, "gyros",850));
        m1.getFoods().add(new Food(6, "baklava", 300));
        return r1;
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodById(int id) {
        Set<String> restaurants= restaurantMap.keySet();
        Iterator<String> iter = restaurants.iterator();
        while (iter.hasNext()) {
          Restaurant restaurant = restaurantMap.get(iter.next());
          Collection<Food> foods = restaurant.getMenu().getFoods();
          for (Food food : foods) {
              if(food.getId() == id)
                  return food;
              }          
        }        
        return null;        
    }
}
