package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;

public interface ShoppingCart {

	public abstract CustomerOrder getCustomerOrder();

	public abstract ShoppingCart withCustomer(String customer);

	public abstract ShoppingCart withDeliveryAddress(
			Address deliveryAddress);

	public abstract ShoppingCart withBillingAddress(
			Address billingAddress);

	public abstract ShoppingCart withFood(int fid);

	public abstract ShoppingCart withFood(int fid, int quantity);

	public abstract void checkout();

}