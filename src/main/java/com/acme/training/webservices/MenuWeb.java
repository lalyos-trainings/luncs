
package com.acme.training.webservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.FoodView;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Food;

import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryRestaurantRepository;
import com.acme.training.service.ShoppingCart;

@Component
@WebService
public class MenuWeb {
    
    @Autowired
    private InMemoryRestaurantRepository repository;
    
    @Autowired
    private ShoppingCartContainer container;
    
    @Autowired
    private InMemoryOrderService orderService;
    
    private List<FoodView> foods = null;
    
    public void init() {
        
        foods = new ArrayList<FoodView>();
        
        for (Restaurant restaurant : repository.getAllRestaurants()) {
            Menu menu = restaurant.getMenu();
            for (Food f : menu.getFoods()) {
                foods.add(new FoodView(f.getName(), f.getId(), f.getPrice()));
            }
            
        }
        System.out.println(foods);
        System.out.println(container);
    }
    
    @WebMethod
    public Collection<FoodView> getFoods() {
        return foods;
    }
    
    @WebMethod
    public int setCustomer(String name, int shoppingCartId) {
        ShoppingCartContainer.Pair pair;
        pair = container.getCart(shoppingCartId);
        pair.getCart().setCustomer(name);
        return pair.getId();
    }
    
    @WebMethod
    public int setDeliveryAddress(Address address, int shoppingCartId) {
        ShoppingCartContainer.Pair pair;
        pair = container.getCart(shoppingCartId);
        pair.getCart().setDeliveryAddress(address);
        return pair.getId();
    }
    
    @WebMethod
    public int setBillingAddress(Address address, int shoppingCartId) {
        ShoppingCartContainer.Pair pair;
        pair = container.getCart(shoppingCartId);
        pair.getCart().setBillingAddress(address);
        return pair.getId();
    }
    
    @WebMethod
    public int addFood(int foodId, int count, int shoppingCartId) {
        ShoppingCartContainer.Pair pair;
        pair = container.getCart(shoppingCartId);
        Food food = repository.getFoodById(foodId);
        if ( food == null ) {
            throw new RuntimeException("no food found for id " + foodId);
        }
        pair.getCart().addFood(food, count);
        return pair.getId();
    }
    
    @WebMethod
    public void sendOrder(int shoppingCartId) {
        ShoppingCart cart = container.getExistingCart(shoppingCartId);
        orderService.doOrder( cart.checkout() );
    }
    
    @WebMethod
    public String viewOrder(int shoppingCartId) {
        ShoppingCart cart = container.getExistingCart(shoppingCartId);
        return cart.getOrder().toString();
    }
}