package com.acme.training.ws;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.OrderService;
import com.acme.training.service.RestaurantRepository;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {
    
    @Autowired
    private ApplicationContext context;
    
    private Logger logger = LoggerFactory.getLogger(ShoppingCartWS.class);
    
    private Map<Integer, ShoppingCart> cartMap = new HashMap<Integer, ShoppingCart>(); 
    
    public void init() {
                
    }
    
    public ShoppingCartWS() {
    }
    
    @WebMethod
    public Integer getShoppingCart(String customer) {
        logger.debug("getShoppingCart() request: ",customer);
        ShoppingCart nextCart = context.getBean(InMemoryShoppingCart.class);
        nextCart.withCustomer(customer);
        int cartId = nextCart.getId();
        cartMap.put(cartId, nextCart);
        logger.info("New ShoppingCart created for " + customer + " with ID " + cartId);
        
        return cartId;
    }
    
    @WebMethod
    public boolean addFood(int cartId, int foodId, int quantity) {
        logger.debug("addFood() request [cartId=" + cartId +"; foodId=" + foodId + "; quantity=" + quantity +"]");
        ShoppingCart cart = cartMap.get(cartId);
        if ((cart != null) && (quantity > 0)) {
            cart.withFood(foodId, quantity);
            logger.info("Food (id: " + foodId + ", q: " + quantity + ") added to cart (id: " + cartId +")");
            return true;
        } else {
            logger.warn("addFood() request: invalid request: cartId="+cartId+"; foodId="+foodId+"; quantity="+quantity);
            return false;
        }                
    }
    
    @WebMethod
    public boolean setDeliveryAddress(int cartId, String city, String street, String zip, String country) {
        logger.debug("setDeliveryAddress() request [cartId=" + cartId + "; city=" + city + "; street=" + street + "; zip=" + zip + "; country=" + country + "]");
        ShoppingCart cart = cartMap.get(cartId);
        if (cart != null) {            
            cart.withDeliveryAddress(new Address(street, city, zip, country));
            logger.info("New DeliveryAddress set for cart ID: "+cartId);
            return true;
        } else {
            logger.warn("setDeliveryAddress() request: invalid cartId: "+cartId);
            return false;
        }   
    }
    
    @WebMethod
    public String checkout(int cartId) {
        logger.debug("checkout() request [cartId=" + cartId + "]");
        ShoppingCart cart = cartMap.get(cartId);
        if (cart != null) {
            cart.checkout();
            logger.info("checkout() successful for cart ID: "+cartId);
            return cart.getCustomerOrderId();
        } else {
            logger.warn("setDeliveryAddress() request: invalid cartId: "+cartId);
            return null;
        }           
    }  
    
    public void printData() {
        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("This OS is "+orderService+" hashcode: "+orderService.hashCode());
        for (CustomerOrder order : orderService.getAllOrder()) {
            System.out.println("- next order:" + order);
            order.printBill();
        }
    }

}
