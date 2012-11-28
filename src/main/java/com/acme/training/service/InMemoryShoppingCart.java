package com.acme.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingCart implements BeanNameAware, ShoppingCart{

    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;    
    private Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    // (user)id : RestaurantOrder[]
    private Collection<OrderItem> orderItems = new  ArrayList<OrderItem>();
    private CustomerOrder customerOrder = new CustomerOrder();

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#getCustomerOrder()
	 */
    public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	private InMemoryShoppingCart() {
        
    }
    
    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withCustomer(java.lang.String)
	 */
    public ShoppingCart withCustomer(String customer) {
    	this.customerOrder.setCustomer(customer);
        return this;
    }
    
    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withDeliveryAddress(com.acme.training.domain.Address)
	 */
    public ShoppingCart withDeliveryAddress(Address deliveryAddress) {
        this.customerOrder.setDeliveryAddress(deliveryAddress);
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withBillingAddress(com.acme.training.domain.Address)
	 */
    public ShoppingCart withBillingAddress(Address billingAddress) {
    	this.customerOrder.setBillingAddress(billingAddress);
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withFood(int)
	 */
    public ShoppingCart withFood(int fid) {
        return withFood(fid, 1);
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withFood(int, int)
	 */
    public ShoppingCart withFood(int fid, int quantity) {
        Food food = repo.findFoodById(fid);
        this.orderItems.add(new OrderItem(quantity, food));
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#checkout()
	 */
    public void checkout() {
    	Map<Restaurant, RestaurantOrder> restaurantOrders = new HashMap<Restaurant, RestaurantOrder>();
    	for (OrderItem oi : orderItems)
    	{
    		Restaurant r = oi.getFood().getRestaurant();
    		RestaurantOrder ro = restaurantOrders.get(r);
    		if (ro == null)
    		{
    			ro = new RestaurantOrder();
    			ro.addOrderItem(oi);
    			restaurantOrders.put(r, ro);
    		}
    		else
    		{
    			ro.addOrderItem(oi);
    		}
    	}
    	
    	CustomerOrder co = this.customerOrder;
    	for (RestaurantOrder ro : restaurantOrders.values())
    		co.addRestaurantOrder(ro);
        orderService.doOrder(co);
        logger.info("checking out order:" + co.getId());
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setBeanName(String name) {
        logger.info("my name is: " + name);
        logger.info("my hashCode is: " + hashCode());
        
    }

}
