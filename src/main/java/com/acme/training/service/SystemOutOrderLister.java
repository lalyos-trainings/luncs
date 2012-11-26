package com.acme.training.service;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

public class SystemOutOrderLister implements OrderLister, ApplicationContextAware {

	private OrderService os;
	private ApplicationContext ctx;
	
	public void setOrderService(OrderService os) {
		// TODO Auto-generated method stub
		this.os = os;
	}

	public void doList() {
		// TODO Auto-generated method stub
		String customer = ctx.getMessage("customer", null, new Locale( "hu"));
		for (Order order : os.getAllOrders()) {
            System.out.println("======");
			System.out.println(customer + ": " + order.getCustomer());
			System.out.println("Billing Address: " + order.getBillingAddress());
			System.out.println("Delivery Address: " + order.getDeliveringAddress());
			for (OrderItem oi: order.getItems()) {
            	System.out.println(oi);
            }
			System.out.println("======");
        }

		System.out.flush();
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		ctx = applicationContext;
	}

}
