package com.epam.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.epam.training.service.RestaurantRepository;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/beans.xml"));
        Object bean = factory.getBean("repo");
        RestaurantRepository repo = (RestaurantRepository) bean;
        System.out.println("restaurant repo resti number: " + repo.getAllRestaurants().size());
    }

}
