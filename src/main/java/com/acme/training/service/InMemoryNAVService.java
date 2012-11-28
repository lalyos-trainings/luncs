package com.acme.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryNAVService implements ApplicationListener<OrderEvent> {

	private Map<Restaurant, Integer> income = new HashMap<Restaurant, Integer>();
	@Autowired
	private ApplicationContext context;
	@Value("${vat.value}")
	private float vat;
	
	public void onApplicationEvent(OrderEvent event) {
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (RestaurantOrder restaurantOrder : event.getOrder().getRestaurantOrders()) {
			items.addAll(restaurantOrder.getOrderItems());
		}
		for (OrderItem item : items) {
			addIncome(item);			
		}
	}

	private void addIncome(OrderItem item) {
		Restaurant restaurant = item.getFood().getRestaurant();
		int price = item.getFood().getPrice();
		price *= item.getQuantity();
		if (income.containsKey(restaurant)) {
			price += income.get(restaurant);
		}
		income.put(restaurant, price);
	}
	
	public void showIncome() {
		System.out.println("\n\n ======== NAV ============");
		float vatd = 1 + vat/100;
		for (Map.Entry<Restaurant, Integer> entry : income.entrySet()) {
			System.out.format("\n étterem: %15s - bevétel: %,6.2f ft", entry.getKey().getName(), entry.getValue()*vatd);
		}
	}
	
}
