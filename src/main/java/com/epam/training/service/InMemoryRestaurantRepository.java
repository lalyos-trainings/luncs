package com.epam.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.epam.training.domain.Food;
import com.epam.training.domain.Menu;
import com.epam.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    private ArrayList<Food> foodList = new ArrayList<Food>();
    
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public InMemoryRestaurantRepository() {
        addRestaurant(createResti1());
        addRestaurant(createResti2());        
    }
    
    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        Food f1 = new Food(1, "pacal", 500);
        Food f2 = new Food(2, "toltott kaposzta",750);
        Food f3 = new Food(3, "bableves", 690);
        m1.getFoods().add(f1);
        m1.getFoods().add(f2);
        m1.getFoods().add(f3);
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        
        Food f1 = new Food(4, "lencse leves", 400);
        Food f2 = new Food(5, "gyros",850);
        Food f3 = new Food(6, "baklava", 300);
        
        m1.getFoods().add(f1);
        m1.getFoods().add(f2);
        m1.getFoods().add(f3);
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        return r1;
    }

    /* (non-Javadoc)
     * @see com.epam.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodbyId(int id) {        
        for (Food f: foodList){
            if (f.getId() == id){
                return f;
            }
        }
        return null;
    }
}
