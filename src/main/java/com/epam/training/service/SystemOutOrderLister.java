package com.epam.training.service;

import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class SystemOutOrderLister implements OrderLister {

	private OrderService os;
	
	public void setOrderService(OrderService os) {
		// TODO Auto-generated method stub
		this.os = os;
	}

	public void doList() {
		// TODO Auto-generated method stub
		for (Order order : os.getAllOrders()) {
            System.out.println("======");
			System.out.println("Customer: " + order.getCustomer());
			System.out.println("Billing Address: " + order.getBillingAddress());
			System.out.println("Delivery Address: " + order.getDeliveringAddress());
			for (OrderItem oi: order.getItems()) {
            	System.out.println(oi);
            }
			System.out.println("======");
        }

		System.out.flush();
	}

}
