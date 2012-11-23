package com.epam.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.epam.training.service.InMemoryRestaurantRepository;
import com.epam.training.service.MenuLister;
import com.epam.training.service.RestaurantRepository;
import com.epam.training.service.SysoutMenuLister;

public class App {

    /**
* @param args
*/
    public static void main(String[] args) {
    /*   RestaurantRepository repo = new InMemoryRestaurantRepository();
        SysoutMenuLister lister = new SysoutMenuLister();
        lister.setRepo(repo);
        lister.doList(); */
        
    //   XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("csing.xml");
//        System.out.println("beans: " +ctx.getBeanDefinitionCount());
                
      // Object bean = factory.getBean("repo");
      // RestaurantRepository repo = (RestaurantRepository) bean;
       
     //  RestaurantRepository repo = factory.getBean("repo", RestaurantRepository.class);
       // w/o "repo" it works too
       
//       MenuLister lister = factory.getBean(MenuLister.class);
      
        MenuLister lister = ctx.getBean(MenuLister.class);
        
       lister.doList();
       
    //   System.out.println("# of restaureants: " + repo.getAllRestaurants().size());
       
      // System.out.println("beans: " + factory.getBeanDefinitionNames());
       
//       RestaurantRepository rrr = ctx.getBean(RestaurantRepository.class);
       
    }

}
