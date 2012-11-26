package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.Order;

public interface MenuLister {

    public void doList();

    public void printOrders(List<Order> orders);

}