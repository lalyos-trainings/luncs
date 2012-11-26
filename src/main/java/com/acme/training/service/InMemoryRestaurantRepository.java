package com.acme.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

public class InMemoryRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();

    public InMemoryRestaurantRepository() {
        // generateTestInstances();
        super();
    }

    /**
     * @see com.acme.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public void addRestaurant(String key, Restaurant restaurant) {
        restaurantMap.put(key, restaurant);
    }

    public void removeRestaurant(String key) {
        restaurantMap.remove(key);
    }

    private void generateTestInstances() {
        Address a1 = new Address("1088", "Magyarország", "Budapest", "Práter utca");
        Collection<Food> foods1 = new ArrayList<Food>();
        foods1.add(new Food("Káposztás tészta", 350, "Kockatészta reszelt, párolt káposztával és sok borssal."));
        foods1.add(new Food("Rántott csirkemell", 750, "Rántott csirkemell"));
        Menu m1 = new Menu(foods1, 1);
        Restaurant r1 = new Restaurant("Dezső bá", a1, m1);

        Address a2 = new Address("113x", "Magyarország", "Budapest", "Pozsonyi utca");
        Collection<Food> foods2 = new ArrayList<Food>();
        foods2.add(new Food("Szűzérmék Calvados mártással", 2500, "Szűzérmék baconbe gyöngyölve, almás mártással."));
        foods2.add(new Food("Marhabélszín erdei gombával", 3500, "Marhabélszín többféle erdei gombával."));
        Menu m2 = new Menu(foods2, 1);
        Restaurant r2 = new Restaurant("Szilvakék paradicsom", a2, m2);

        restaurantMap.put("elso", r1);
        restaurantMap.put("masodik", r2);
    }

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public Food findFoodById(String restiName, String foodName) {
        Food tmp = null;
        Food r = null;
        boolean found = false;
        for (Restaurant resti : getAllRestaurants()) {
            if (resti.getName().equalsIgnoreCase(restiName)) {
                Iterator<Food> it = resti.getMenu().getFoods().iterator();
                while (!found && it.hasNext()) {
                    tmp = it.next();
                    if (tmp.getName().equalsIgnoreCase(foodName)) {
                        found = true;
                        r = tmp;
                    }
                }
            }
        }
        return r;
    }

    public Food findFoodById(String foodName) {
        Food tmp = null;
        Food r = null;
        boolean found = false;
        for (Restaurant resti : getAllRestaurants()) {
            Iterator<Food> it = resti.getMenu().getFoods().iterator();
            while (!found && it.hasNext()) {
                tmp = it.next();
                if (tmp.getName().equalsIgnoreCase(foodName)) {
                    found = true;
                    r = tmp;
                }
            }
        }
        return r;
    }

}
