package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.ShoppingCart;

@Component
@WebService
public class ShoppingCartWS {
	
	private int idCounter = 0;
	
	@Autowired
	private ApplicationContext ctx;
	
	private Map<Integer, ShoppingCart> userCarts = new HashMap<Integer, ShoppingCart>();
	
	public Integer getShoppingCart(String customer)
	{
		int id = idCounter++;
		ShoppingCart sc = ctx.getBean(ShoppingCart.class);
		sc.withCustomer(customer);
		userCarts.put(id, sc);
		return id;
	}
	
	public void addFood(Integer uid, Integer fid, Integer quantity)
	{
		this.userCarts.get(uid).withFood(fid, quantity);
	}
	
	public void setDeliveryAddress(Integer uid, String street, String city, String zip, String country)
	{
		Address addr = new Address(street, city, zip, country);
		this.userCarts.get(uid).withBillingAddress(addr).withDeliveryAddress(addr);
	}
	
	public String checkout(Integer uid)
	{
		this.userCarts.get(uid).checkout();
		return this.userCarts.get(uid).getCustomerOrder().getId();
	}
}
