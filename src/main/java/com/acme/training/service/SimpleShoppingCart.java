package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SimpleShoppingCart implements BeanNameAware, ShoppingCart{

    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;    
    private Order order;
    private Logger logger = LoggerFactory.getLogger(SimpleShoppingCart.class);

    private SimpleShoppingCart() {
        this.order = new Order();
    }
    
    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withCustomer(java.lang.String)
	 */
    public ShoppingCart withCustomer(String customer) {
        order.setCustomer(customer);
        return this;
    }
    
    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withDeliveryAddress(com.acme.training.domain.Address)
	 */
    public ShoppingCart withDeliveryAddress(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withBillingAddress(com.acme.training.domain.Address)
	 */
    public ShoppingCart withBillingAddress(Address billingAddress) {
        order.setBillingAddress(billingAddress);
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withFood(int)
	 */
    public ShoppingCart withFood(int id) {
        return withFood(id, 1);
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#withFood(int, int)
	 */
    public ShoppingCart withFood(int id, int quantity) {
        Food food = repo.findFoodById(id);
        order.addItem(new OrderItem(quantity, food));
        return this;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#checkout()
	 */
    public void checkout() {
        orderService.doOrder(order);
        logger.info("checking out order:" + order.getId());
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#getOrderService()
	 */
    public OrderService getOrderService() {
        return orderService;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#setOrderService(com.acme.training.service.OrderService)
	 */
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /* (non-Javadoc)
	 * @see com.acme.training.service.ShoppingCart#setBeanName(java.lang.String)
	 */
    public void setBeanName(String name) {
        logger.info("my name is: " + name);
        logger.info("my hashCode is: " + hashCode());
        
    }

}
