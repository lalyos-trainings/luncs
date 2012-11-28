package com.acme.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.MenuLister;
import com.acme.training.service.SandBoxRepo;

public class Sandbox {

	@Autowired
	private SandBoxRepo repo;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans.xml", "kfc.xml", "csing.xml");

	}

}
