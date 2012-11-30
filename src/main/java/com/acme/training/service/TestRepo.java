package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;


public class TestRepo {
    
    
    
    public TestRepo(){
        
        Restaurant rest = new Restaurant("Lökk", "Muku utca 32", "2222");
        Restaurant rest2 = new Restaurant("Plukk", "Mukulkuku utca 332", "2352");
        Food food = new Food("csucsu", 500, rest,10);
        Food food2 = new Food("löll", 340, rest, 11);
        Food food3 = new Food("möll", 595, rest2,12);
        Food food4 = new Food("fjall", 2430, rest2, 13);
              
        OrderItem  item = new OrderItem(2, food);
        OrderItem  item2 = new OrderItem(4, food2);
        OrderItem  item3 = new OrderItem(3, food3);
        OrderItem  item4 = new OrderItem(2, food4);
        
        RestaurantOrder ro = new RestaurantOrder(rest);
        ro.addItem(item);
        ro.addItem(item2);
        RestaurantOrder ro2 = new RestaurantOrder(rest2);
        ro2.addItem(item3);
        ro2.addItem(item4);
        
        CustomerOrder co = new CustomerOrder();
        Address addr = new Address();
        co.getCustomer().setName("Béla");
        co.getCustomer().setDeliveryAddress(addr);
        co.addRestaurantOrder(ro);
        co.addRestaurantOrder(ro2);
        
        
        co.printBill();
    
    }
    
   
    
    
    public void setBeanName(String arg0) {
        // TODO Auto-generated method stub
        
    }

}




/* private void addRestaurant(Restaurant restaurant) {
restaurantMap.put(restaurant.getName(), restaurant);
registerFoods(restaurant);
}

private Restaurant createResti1() {
Restaurant r1 = new Restaurant("Lökk", "Muku utca 32", "2222");
Menu m1 = new Menu();
r1.setMenu(m1);
m1.setWeek(34);
m1.getFoods().add(new Food("csucsu", 500, r1,10));
m1.getFoods().add(new Food("melep",750, r1,11));
m1.getFoods().add(new Food("szembak", 690, r1,12));
return r1;
}

private Restaurant createResti2() {
Restaurant r1 = new Restaurant("Lökk", "Muku utca 32", "2222");
Menu m1 = new Menu();
r1.setMenu(m1);
m1.setWeek(34);
m1.getFoods().add(new Food("lülü", 500, r1,13));
m1.getFoods().add(new Food("kanflanf",750, r1,14));
m1.getFoods().add(new Food("öllmöll", 690, r1,15));
return r1;
}

*/
