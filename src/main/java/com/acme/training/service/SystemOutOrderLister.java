package com.acme.training.service;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component
public class SystemOutOrderLister implements OrderLister, ApplicationContextAware {

	private OrderService os;
	private ApplicationContext ctx;
	private Locale locale;
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setOrderService(OrderService os) {
		// TODO Auto-generated method stub
		this.os = os;
	}

	public void doList() {
		// TODO Auto-generated method stub
		String customer = ctx.getMessage("customer", null, locale);
		String baddress = ctx.getMessage("baddress", null, locale);
		String daddress = ctx.getMessage("daddress", null, locale);
		String food =  ctx.getMessage("food", null, locale);
		for (Order order : os.getAllOrders()) {
            System.out.println("======");
			System.out.println(customer + ": " + order.getCustomer());
			System.out.println(baddress + ": " + order.getBillingAddress());
			System.out.println(daddress + ": " + order.getDeliveringAddress());
			for (OrderItem oi: order.getItems()) {
            	System.out.println(food + ": " + oi.getQuantity() + "x " + oi.getFood().getName());
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
