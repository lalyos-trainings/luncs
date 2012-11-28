package com.acme.training.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;


@WebService
@Component
public class ShoppingCartWS {
    @Autowired
    private ApplicationContext ctx;
    @Autowired
    OrderService orderService;// = ctx.getBean(OrderService.class);
   
    
    public Integer getShoppingCart (@WebParam(name="customer")String customer){
         return orderService.addNewShoppingCart(customer);
               
        
    };
    
    public void setDeliveryAddress(@WebParam(name="scId") int scId,@WebParam(name="city") String city,@WebParam(name="street") String street,@WebParam(name="zip") String zip,@WebParam(name="country") String country){
        ShoppingCart cart = orderService.getShoppingCartById(scId);
        cart.withDeliveryAddress(new Address(street, city, zip, country));
        
    }
    
    public void addFood(@WebParam(name="scId")int scId,@WebParam(name="foodId") int foodId, @WebParam(name="quantity")int quantity){
        ShoppingCart cart = orderService.getShoppingCartById(scId);
        cart.withFood(foodId, quantity);
    }
    
    public int checkout(@WebParam(name="scId") int scId){
        ShoppingCart cart = orderService.getShoppingCartById(scId);
            return cart.checkout();
              
    }

}
