package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

@Component("memoryRest")
public class InMemoryRestaurantRepository implements RestaurantRepository, BeanNameAware 
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    
    protected Map<String, Restaurant> restaurantMap = new HashMap<String, Restaurant>();
    
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

    /* (non-Javadoc)
     * @see com.acme.training.service.RestaurantRepository#getAllRestaurants()
     */
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantMap.values();
    }

    public Food getFoodById(int foodId) 
    {
        Food foundFood = null;
        
        Iterator<Restaurant> iterator = restaurantMap.values().iterator();
        
        while (iterator.hasNext() == true && foundFood == null)
        {
            Restaurant restaurant = iterator.next();
            Menu menu = restaurant.getMenu();
            Collection<Food> foods = menu.getFoods();
            
            Iterator<Food> foodIterator = foods.iterator();
            
            while (foodIterator.hasNext() == true)
            {
                Food food = foodIterator.next();
                if (food.getId() == foodId)
                {
                    foundFood = food;
                    break;
                }
            }
        }
        
        return foundFood;
    }

    public void setBeanName(String beanName) 
    {
        logger.info("bean name: " + beanName);
    }
}
