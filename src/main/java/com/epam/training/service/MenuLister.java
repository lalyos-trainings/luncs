package com.epam.training.service;

import java.util.List;

import com.epam.training.domain.Order;

public interface MenuLister {

    public void doList();

    public void printOrders(List<Order> orders);

}