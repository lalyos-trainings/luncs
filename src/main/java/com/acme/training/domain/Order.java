package com.acme.training.domain;

import java.util.ArrayList;
import java.util.List;


public class Order {
	private String customer;
	private Address billingAddress;
	private Address deliveringAddress;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {}
	public Order(List<OrderItem> items) {
		this.items = items;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getDeliveringAddress() {
		return deliveringAddress;
	}

	public void setDeliveringAddress(Address deliveringAddress) {
		this.deliveringAddress = deliveringAddress;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
