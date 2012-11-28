package com.acme.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.domain.Address;
import com.acme.domain.CustomerOrder;
import com.acme.domain.Food;
import com.acme.domain.OrderItem;
import com.acme.domain.Restaurant;
import com.acme.domain.RestaurantOrder;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {
    
    private CustomerOrder customerOrder;
    @Autowired
    private RestaurantRepository repo;
    @Autowired
    private OrderService orderService;
    private Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    
   
    
    public InMemoryShoppingCart(){
        this.customerOrder = new CustomerOrder();
        this.repo = new InMemoryRestaurantRepository();
    }
    
    public void addFood(int foodId, int quantity){
        Food food = this.repo.getFoodbyId(foodId);
        addFoodToRestaurantOrder(food, quantity);
    }
    
    private void addFoodToRestaurantOrder(Food food, int quantity){
        Restaurant restaurant = food.getRestaurant();
        
        Collection<RestaurantOrder> restaurantOrders = customerOrder.getRestaurantOrders();
        boolean orderContainsRestaurant = false;
        
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            if(restaurantOrder.getRestaurant().equals(restaurant)){
                orderContainsRestaurant = true;
                updateRestaurantOrder(restaurantOrder, food, quantity);
                break;
            }
        }
        
        if(!orderContainsRestaurant){
            createNewRestaurantOrder(food, quantity, restaurant);
        }
    }
    
    private void updateRestaurantOrder(RestaurantOrder restaurantOrder, Food food, int quantity){
        OrderItem orderItem = new OrderItem();        
        orderItem.setFood(food);
        orderItem.setQuantity(quantity);
        restaurantOrder.addOrderItem(orderItem);
    }
    
    private void createNewRestaurantOrder(Food food, int quantity, Restaurant restaurant){
        RestaurantOrder restaurantOrder = new RestaurantOrder(restaurant);
        OrderItem orderItem = new OrderItem();        
        orderItem.setFood(food);
        orderItem.setQuantity(quantity);
        restaurantOrder.addOrderItem(orderItem);
        customerOrder.addRestaurantOrder(restaurantOrder);
    }
   
    public void setCustomer(String customer){
        customerOrder.setCustomer(customer);
    }
    
    
    public void setDeliveryAddress(Address address){
        customerOrder.setDeliveryAddress(address);
    }
    
   
    public void setBillingAddress(Address address){
        customerOrder.setBillingAddress(address);
    }

    public void checkout() {      
        orderService.doOrder(customerOrder);
    }

    public void setBeanName(String arg0) {
        logger.info("shopping carts name:"+arg0+" hashcode:"+this.hashCode());
    }
    
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
 
    public OrderService getOrderService() {
        return orderService;
    }

}
