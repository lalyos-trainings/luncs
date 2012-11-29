package com.acme.training.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.CheckOutEvent;
import com.acme.training.service.OrderService;
import com.acme.training.service.RestaurantRepository;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {

	@Autowired
	OrderService orderService;
	@Autowired
	ApplicationContext context;
	@Autowired
	private RestaurantRepository repo;
	
	public int getShoppingCart(String customer) {
		return orderService.addNewShoppingCart(customer);
	}
	
	public void addFood(int cartId, Integer foodId, int quantity) {
		orderService.getShoppingCartById(cartId).withFood(foodId, quantity);
	}
	
	public void setDeliveryAddress(int cartId, String city, String street, String zip, String country) {
		ShoppingCart shoppingCart = orderService.getShoppingCartById(cartId);
		Address deliveryAddress = new Address(street, city, zip, country);
		shoppingCart.withDeliveryAddress(deliveryAddress);
	}
	
	public String checkOut(int cartId) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmsszzz").format(new Date());
		ShoppingCart cart = orderService.getShoppingCartById(cartId);
		context.publishEvent(new CheckOutEvent(this, timeStamp, cart));
		return timeStamp;
	}
}
