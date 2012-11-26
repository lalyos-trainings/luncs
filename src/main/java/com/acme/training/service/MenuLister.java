package com.acme.training.service;


public interface MenuLister 
{
	void setRestaurantRepository(RestaurantRepository rp);
	void doList();
}
