package com.epam.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.epam.training.domain.Food;
import com.epam.training.domain.Menu;
import com.epam.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    
    public InMemoryRestaurantRepository() {
        //addRestaurant(createResti1());
        //addRestaurant(createResti2());        
    }
        
    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
        Set<String> keySet = restaurantMap.keySet();
        for (String key : keySet) {
            System.out.println("next repo key:" + key);
            
        }
    }

    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("pacal", 500));
        m1.getFoods().add(new Food("toltott kaposzta",750));
        m1.getFoods().add(new Food("bableves", 690));
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("lencse leves", 400));
        m1.getFoods().add(new Food("gyros",850));
        m1.getFoods().add(new Food("baklava", 300));
        return r1;
    }

    /* (non-Javadoc)
     * @see com.epam.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

}
