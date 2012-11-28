package com.acme.ws;

import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.domain.Address;
import com.acme.service.InMemoryShoppingCart;
import com.acme.service.ShoppingCart;


@Component
@WebService
public class ShoppingCartWS{
    
    @Autowired
    private ApplicationContext ctx;
    private Collection<InMemoryShoppingCart> shoppingCarts = new ArrayList<InMemoryShoppingCart>();

    @WebMethod
    public Integer getShoppingCart(@WebParam(name="Customer")String customer){
        InMemoryShoppingCart cart = ctx.getBean(InMemoryShoppingCart.class);
        shoppingCarts.add(cart);
        cart.setCustomer(customer);
        
        int shoppingCartId = cart.getShoppingCartId();        
        return shoppingCartId;
    }
    
    @WebMethod
    public void addFood(@WebParam(name ="ShoppingCartId")int scId, @WebParam(name ="FoodId")int foodId, @WebParam(name ="Quantity")int quantity){
        for (InMemoryShoppingCart sc:shoppingCarts){
            if(sc.getShoppingCartId() == scId){
                sc.addFood(foodId, quantity);
            }            
        }
    }
    
    @WebMethod
    public void setDeliveryAddress(@WebParam(name ="ShoppingCartId")int scId,@WebParam(name="City")String city,@WebParam(name="Street") String street,@WebParam(name="Zip")String zip, @WebParam(name="Country")String country){
        for (InMemoryShoppingCart sc:shoppingCarts){
            if(sc.getShoppingCartId() == scId){
                sc.setDeliveryAddress(new Address(street, city, zip, country));
            }            
        }
    }
    
    @WebMethod
    public void setBillingAddress(@WebParam(name ="ShoppingCartId")int scId,@WebParam(name="City")String city,@WebParam(name="Street") String street,@WebParam(name="Zip")String zip, @WebParam(name="Country")String country){
        for (InMemoryShoppingCart sc:shoppingCarts){
            if(sc.getShoppingCartId() == scId){
                sc.setBillingAddress(new Address(street, city, zip, country));
            }            
        }
    }
    
    @WebMethod
    @WebResult(name="orderId")
    public int checkout(@WebParam(name="ShoppingCartId")int scId){
        int orderId=-1;
        for (InMemoryShoppingCart sc:shoppingCarts){
            if(sc.getShoppingCartId() == scId){
                orderId = sc.checkout();
            }            
        }
        return orderId;
    }
    
}
