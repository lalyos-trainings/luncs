package com.acme.training.service;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Customer;
import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component
public class SandBoxRepo {
	
	public SandBoxRepo() {
		System.out.println("**** SandBoxRepo ****");
		
		Restaurant rest1 = createResti1();
		Restaurant rest2 = createResti2();
		
		Customer cust1 = createCusti1();
		Customer cust2 = createCusti2();
		RestaurantOrder ro1 = new RestaurantOrder( rest1, cust1 );
		RestaurantOrder ro2 = new RestaurantOrder( rest2, cust2 );
		
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
	
	private Restaurant createResti1() {
		Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
		Menu m1 = new Menu();
		r1.setMenu(m1);
		m1.setWeek(34);
		m1.getFoods().add(new Food("pacal", 500, r1));
		m1.getFoods().add(new Food("toltott kaposzta", 750, r1));
		m1.getFoods().add(new Food("bableves", 690, r1));
		return r1;
	}

	private Restaurant createResti2() {
		Restaurant r1 = new Restaurant("Kifozde", "Gyilkos galoca utca 52", "1082");
		Menu m1 = new Menu();
		r1.setMenu(m1);
		m1.setWeek(34);
		m1.getFoods().add(new Food("gombapaprikas", 500, r1));
		m1.getFoods().add(new Food("toltott gomba", 750, r1));
		m1.getFoods().add(new Food("gombaleves", 690, r1));
		return r1;
	}

}
