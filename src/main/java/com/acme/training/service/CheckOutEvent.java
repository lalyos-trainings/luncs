package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.ws.ShoppingCartWS;

@SuppressWarnings("serial")
public class CheckOutEvent extends ApplicationEvent {

	private String timeStamp;
	private ShoppingCart cart;

	public CheckOutEvent(ShoppingCartWS source, String timeStamp, ShoppingCart cart) {
		super(source);
		this.timeStamp = timeStamp;
		this.cart = cart;
	}

	public ShoppingCart getCart() {
		return cart;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
}
