package com.acme.training.service;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Customer;
import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component
public class SandBoxRepo {
	
	public SandBoxRepo() {
		System.out.println("**** SandBoxRepo ****");
		
		Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
		Restaurant r2 = new Restaurant("Kifozde", "Gyilkos galoca utca 52", "1082");

		Restaurant rest1 = createResti1(r1);
		Restaurant rest2 = createResti2(r2);
		
		Customer cust1 = createCusti1();
		Customer cust2 = createCusti2();

		OrderItem oi1 = new OrderItem(10, new Food(1, "makoslaska", 10, r1));
		OrderItem oi2 = new OrderItem(03, new Food(2, "leveske", 210, r1));
		OrderItem oi3 = new OrderItem(04, new Food(3, "kaposzta", 310, r1));
		OrderItem oi4 = new OrderItem(01, new Food(4, "makoslaska2", 210, r2));
		OrderItem oi5 = new OrderItem(01, new Food(5, "leveske2", 2210, r2));
		OrderItem oi6 = new OrderItem(04, new Food(6, "kaposzta2", 3210, r2));
		OrderItem oi7 = new OrderItem(04, new Food(6, "kaposzta2", 3210, r2));
		
		RestaurantOrder ro1 = new RestaurantOrder( rest1, cust1 );
		RestaurantOrder ro2 = new RestaurantOrder( rest2, cust2 );
		ro1.addItem(oi1);
		ro1.addItem(oi2);
		ro1.addItem(oi3);
		ro2.addItem(oi4);
		ro2.addItem(oi5);
		ro2.addItem(oi6);
		ro2.addItem(oi7);
		
		System.out.println( ro1.toString() );
		System.out.println( ro2.toString() );
	}
	
	private Customer createCusti1(){
		Customer customer = new Customer();
		customer.setName( "Bela" );
		customer.setBillingAddress("Budapest kossuth striit");
		customer.setDeliveryAddress("Budapest kossuth striit");
		return customer;
	}

	private Customer createCusti2(){
		Customer customer = new Customer();
		customer.setName( "Macika" );
		customer.setBillingAddress("Debrecen valahol");
		customer.setDeliveryAddress("Debrecen valahova");
		return customer;
	}
	
	private Restaurant createResti1(Restaurant r1) {
		Menu m1 = new Menu();
		r1.setMenu(m1);
		m1.setWeek(34);
		m1.getFoods().add(new Food("pacal", 500, r1));
		m1.getFoods().add(new Food("toltott kaposzta", 750, r1));
		m1.getFoods().add(new Food("bableves", 690, r1));
		return r1;
	}

	private Restaurant createResti2(Restaurant r1) {
		Menu m1 = new Menu();
		r1.setMenu(m1);
		m1.setWeek(34);
		m1.getFoods().add(new Food("gombapaprikas", 500, r1));
		m1.getFoods().add(new Food("toltott gomba", 750, r1));
		m1.getFoods().add(new Food("gombaleves", 690, r1));
		return r1;
	}

}
